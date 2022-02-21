package com.hopla.demo.config;

import graphql.language.*;
import graphql.schema.idl.SchemaGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.boot.GraphQlSourceBuilderCustomizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class GraphQLConfig {

    @Bean
    public GraphQlSourceBuilderCustomizer graphQlBuilderCustomizer(){
        return  (builder) ->{
            builder.schemaFactory((typeDefinitionRegistry, runtimeWiring) -> {
                Map<String, TypeDefinition> types = typeDefinitionRegistry.types();
                Set<DirectiveSource> pageDirectiveArgumentValues = findPageDirectiveArgumentValues(types);
                if(!pageDirectiveArgumentValues.isEmpty()){
                    List<SDLDefinition> objectTypeDefinitions = createObjectTypeDefinitions(pageDirectiveArgumentValues);
                    typeDefinitionRegistry.addAll(objectTypeDefinitions);
                }
                SchemaGenerator schemaGenerator = new SchemaGenerator();
                return  schemaGenerator.makeExecutableSchema(typeDefinitionRegistry,runtimeWiring);
            });
        };
    }

    private Set<DirectiveSource> findPageDirectiveArgumentValues(Map<String, TypeDefinition> types) {
        return types.values().stream()
                .filter(typeDefinition -> typeDefinition instanceof ObjectTypeDefinition)
                .map(typeDefinition -> (ObjectTypeDefinition) typeDefinition)
                .flatMap(objectTypeDefinition -> objectTypeDefinition.getFieldDefinitions().stream())
                .flatMap(fieldDefinition ->
                        fieldDefinition.getDirectives().stream()
                                .filter(directive -> directive.getName().equals("page"))
                                .map(directive -> (StringValue) directive.getArgument("for").getValue())
                                .map(StringValue::getValue)
                                .map(forValue -> {
                                    Type fieldDefinitionType = fieldDefinition.getType();
                                    String directiveFieldType = null;
                                    if (fieldDefinitionType instanceof NonNullType && ((NonNullType) fieldDefinitionType).getType() instanceof TypeName) {
                                        directiveFieldType = ((TypeName) ((NonNullType) fieldDefinitionType).getType()).getName();
                                    } else {
                                        directiveFieldType = ((TypeName) fieldDefinitionType).getName();
                                    }
                                    return new DirectiveSource(directiveFieldType, forValue);
                                })).collect(Collectors.toSet());
    }

    private List<SDLDefinition> createObjectTypeDefinitions(Set<DirectiveSource>typeNames){

        List<SDLDefinition>pageObjectDefinitions = new ArrayList<>();
        DirectiveDefinition pageDiretiveDefinition = DirectiveDefinition.newDirectiveDefinition().name("page")
                .inputValueDefinition(InputValueDefinition.newInputValueDefinition().name("for").type(new NonNullType(new TypeName("String"))).build())
                .directiveLocation(DirectiveLocation.newDirectiveLocation().name("FIELD_DEFINITION").build())
                .build();
        pageObjectDefinitions.add(pageDiretiveDefinition);
        pageObjectDefinitions.add(
                ObjectTypeDefinition.newObjectTypeDefinition()
                        .name("GraphPageInfo")
                        .fieldDefinition(new FieldDefinition("hasPreviousPage", new NonNullType(new TypeName("Boolean"))))
                        .fieldDefinition(new FieldDefinition("hasNextPage",new NonNullType(new TypeName("Boolean"))))
                        .fieldDefinition(new FieldDefinition("starCursor",new TypeName("String")))
                        .fieldDefinition(new FieldDefinition("endCursor",new TypeName("String")))
                        .build());
                pageObjectDefinitions.addAll(typeNames.stream().map(typeName ->
                        ObjectTypeDefinition.newObjectTypeDefinition()
                                .name(typeName.getSourceFieldName())
                                .fieldDefinition(FieldDefinition.newFieldDefinition().name("content").type(new ListType(new TypeName(typeName.getForArgumentValue()))).build())
                                .fieldDefinition(FieldDefinition.newFieldDefinition().name("pageInfo").type(new TypeName("GraphPageInfo")).build()).build()
                ).collect(Collectors.toList()));

                return pageObjectDefinitions;

    }

    @AllArgsConstructor
    @Getter
    private class DirectiveSource{
        private String sourceFieldName;
        private String forArgumentValue;
    }
}
