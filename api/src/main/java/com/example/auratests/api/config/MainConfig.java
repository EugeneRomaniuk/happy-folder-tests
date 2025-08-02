package com.example.auratests.api.config;

import com.example.auratests.api.config.properties.ApiProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@EnableConfigurationProperties({
        ApiProperties.class
})
@Import({
        ApiConfig.class
})
public class MainConfig {
}
