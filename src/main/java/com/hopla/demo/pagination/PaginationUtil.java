package com.hopla.demo.pagination;

import org.springframework.stereotype.Component;

@Component
public class PaginationUtil {

    public Integer sanetizePageSize(Integer userPageSize,Integer defaultValue){
        return  userPageSize ==null || userPageSize>=defaultValue|| userPageSize <=0 ? defaultValue:userPageSize;
    }
}
