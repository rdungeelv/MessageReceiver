package com.tspi.flow.filter;

import org.springframework.integration.core.GenericSelector;

public class TspiSourceFilter implements GenericSelector<String> {
    @Override
    public boolean accept(String source) {
        System.out.println(source);
        return true;
    }
}
