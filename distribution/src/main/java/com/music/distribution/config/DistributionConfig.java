package com.music.distribution.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DistributionConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
