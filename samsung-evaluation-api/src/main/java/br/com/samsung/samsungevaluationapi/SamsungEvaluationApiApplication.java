package br.com.samsung.samsungevaluationapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication(scanBasePackages = { "br.com.samsung.samsungevaluationapi" })
@EnableFeignClients
@EnableSwagger2
public class SamsungEvaluationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamsungEvaluationApiApplication.class, args);
	}
	
	

}
