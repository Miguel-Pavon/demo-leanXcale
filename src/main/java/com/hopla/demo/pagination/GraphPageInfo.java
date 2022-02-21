package com.hopla.demo.pagination;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class GraphPageInfo {

    private final String startCursor;

    private final String endCursor;

    private final boolean hasPreviousPage;

    private final boolean hasNextPage;
}
