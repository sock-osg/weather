package com.oz.weather.config;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * SwaggerConfig.
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
@Setter
@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "project")
public class SwaggerConfig {

  private String groupId;
  private String version;
  private String name;
  private String description;

  /**
   * Initialize Docket object.
   * @return Docket instance.
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .directModelSubstitute(LocalDate.class, java.sql.Date.class)
        .directModelSubstitute(LocalTime.class, String.class).apiInfo(apiInfo()).select()
        .apis(RequestHandlerSelectors.basePackage(groupId)).build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title(this.name).description(this.description).version(this.version)
        .build();
  }
}
