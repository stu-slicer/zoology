package com.nology.zoology.config;

import com.nology.zoology.animal.loader.AnimalLoader;
import com.nology.zoology.animal.loader.CSVAnimalLoader;
import com.nology.zoology.animal.loader.RandomAnimalLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create a suitable {@link AnimalLoader} if there isn't one already.
 */
@Configuration
public class AnimalLoaderConfig {

    @Value("${animal-loader.type}")
    private AnimalLoaderType loaderType = AnimalLoaderType.random;

    /**
     * Only creates a suitable {@link AnimalLoader} is one hasn't already been created.
     * The specific implementation depends on the application property 'animal-loader.type'
     * This could be the case if an {@link AnimalLoader} implementation has a @{@link org.springframework.stereotype.Component} applied.
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(AnimalLoader.class)
    public AnimalLoader animalLoader() {
        switch (loaderType) {
            case random:
                return new RandomAnimalLoader();
            case csv:
                return new CSVAnimalLoader();
        }
        return new RandomAnimalLoader();
    }

}
