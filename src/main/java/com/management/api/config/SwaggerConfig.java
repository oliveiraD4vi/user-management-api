package com.management.api.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public GroupedOpenApi publicApi() {
      return GroupedOpenApi.builder()
        .group("api")
        .pathsToMatch("/api/**")
        .build();
  }

  @Bean
  public OpenAPI userManagementApi() {
    return new OpenAPI()
      .info(new Info().title("User Management API")
        .description("API para Gerenciamento de usuários")
        .version("v0.0.1")
        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
      .components(new Components())
      .externalDocs(new ExternalDocumentation()
        .description("SpringShop Wiki Documentation")
        .url("https://springshop.wiki.github.org/docs"));
  }
}
