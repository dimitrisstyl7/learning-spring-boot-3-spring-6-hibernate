package com.dimstyl.springcoredemo.config;

import com.dimstyl.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    //@Bean("aquaticCoach")
    @Bean()
    public SwimCoach swimCoach() {
        return new SwimCoach();
    }
}
