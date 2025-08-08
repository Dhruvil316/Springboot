package com.dhruvil.learnSpringbootApp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // indicates that this is configuration class
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper (){
        return new ModelMapper() ;
    }
}
