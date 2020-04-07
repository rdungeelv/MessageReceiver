package com.tspi.flow.filter;

import com.tspi.to.TspiData;
import org.springframework.integration.core.GenericSelector;

public class TspiSourceFilter implements GenericSelector<TspiData> {
    @Override
    public boolean accept(TspiData source) {
        System.out.println(source);
        return true;
    }
}
