package com.example.pesto.central.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:config/dev/central.properties", ignoreResourceNotFound = true)
@PropertySource(value = "classpath:config/dev/auth.properties", ignoreResourceNotFound = true)
@PropertySource(value = "classpath:config/dev/order.properties", ignoreResourceNotFound = true)
@PropertySource(value = "classpath:config/dev/product.properties", ignoreResourceNotFound = true)
@PropertySource(value = "classpath:config/dev/commons.properties", ignoreResourceNotFound = true)
public class ApplicationProperties {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
        return factory -> factory.setContextPath("");
    }

}
