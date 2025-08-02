package com.example.auratests.ui.config;

import com.example.auratests.ui.config.properties.UiProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages = "com.example.auratests.ui.page")
@EnableConfigurationProperties({
        UiProperties.class
})
@Import({
        UiConfig.class
})
public class MainConfig {
}
