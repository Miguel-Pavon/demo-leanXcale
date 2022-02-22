package com.hopla.demo.pagination;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class GraphPageInfo {


    private final int page;

    private final long totalElement;

    private final int totalPage;

    private final boolean hasPreviousPage;

    private final boolean hasNextPage;
}
