package com.example.auratests.ui.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class UiConfig {

    @Profile("chrome")
    @Bean(destroyMethod = "quit")
    public WebDriver webDriver() {
        var driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
