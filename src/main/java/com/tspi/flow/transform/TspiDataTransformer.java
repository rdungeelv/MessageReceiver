package com.tspi.flow.transform;

import com.tspi.to.TspiData;
import org.springframework.integration.transformer.GenericTransformer;

public class TspiDataTransformer implements GenericTransformer<String,TspiData> {

    @Override
    public TspiData transform(String source) {
        if(source != null) {
            String[] values = source.split(",");
            if(values.length == 16) {
                long nanos = (long) Double.parseDouble(values[0]) * 1000000000L;
                return new TspiData(
                        nanos,
                        Double.parseDouble(values[1]),
                        Double.parseDouble(values[3]),
                        Double.parseDouble(values[2]),
                        Double.parseDouble(values[5]),
                        Double.parseDouble(values[6]),
                        Double.parseDouble(values[7]),
                        Integer.parseInt(values[4]),
                        Double.parseDouble(values[9]),
                        Double.parseDouble(values[10]),
                        Double.parseDouble(values[11]),
                        Integer.parseInt(values[8]),
                        Double.parseDouble(values[13]),
                        Double.parseDouble(values[14]),
                        Double.parseDouble(values[15]),
                        Integer.parseInt(values[12]));
            }
        }
        return new TspiData();
    }
}
