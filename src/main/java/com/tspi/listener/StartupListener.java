package com.tspi.listener;

import com.tspi.flow.TspiDataSorter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(StartupListener.class);

    private TspiDataSorter dataSorter;

    public StartupListener(TspiDataSorter dataSorter) {
        this.dataSorter = dataSorter;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOGGER.info("Application started.");

        dataSorter.sort();
    }
}
