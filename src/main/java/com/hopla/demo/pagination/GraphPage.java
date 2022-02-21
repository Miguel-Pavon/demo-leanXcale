package com.hopla.demo.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class GraphPage <T>{

    private List<T>content;

    private GraphPageInfo pageInfo;


}
