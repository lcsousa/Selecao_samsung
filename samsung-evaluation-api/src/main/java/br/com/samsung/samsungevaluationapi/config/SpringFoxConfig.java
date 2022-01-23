package br.com.samsung.samsungevaluationapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
	 @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("br.com.samsung.samsungevaluationapi.controller"))              
	          .paths(PathSelectors.any())                          
	          .build().apiInfo(metaData());                                           
	    }
	 
	 private ApiInfo metaData() {
		    return new ApiInfoBuilder()
		        .title("Processo seletivo da Samsung")
		        .description("Api que faz consulta de documentos ")
		        .version("1.0.0")
		    	        .build();
		  }
}
