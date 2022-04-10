package com.karyasarma.dw_tools_api.configuration

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.context.annotation.Configuration

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Configuration
@OpenAPIDefinition(servers = [Server(url = "/")])
class SpringDocOpenApiUiConfig
