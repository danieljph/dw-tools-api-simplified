package com.karyasarma.dw_tools_api.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Configuration
class SpringValidationConfig
{
    @Bean
    fun validator(): LocalValidatorFactoryBean
    {
        return LocalValidatorFactoryBean()
    }
}
