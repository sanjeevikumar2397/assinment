package com.te.doctorflow1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableSwagger2
public class Doctorflow1Application {

	public static void main(String[] args) {
		SpringApplication.run(Doctorflow1Application.class, args);
	}
	
//	@Bean
//	public Docket swaggerConfiguration(){
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.paths(PathSelectors.ant("/doctor/*"))
//				.apis(RequestHandlerSelectors.basePackage("com.te.doctorflow1"))
//				.build()
//				.apiInfo(apiCustomData());
//	}
//
//	private ApiInfo apiCustomData(){
//		return new ApiInfo(
//				"Cloud Vendor API Application",
//				"Cloud Vendor Documentation",
//				"1.0",
//				"Cloud Vendor Service Terms",
//				new Contact("Esha Puri", "http://thinkconstructive.com",
//						"contact@thinkconstructive.com"),
//				"Think Constructive License",
//				"http://thinkconstructive.com",
//				new ArrayList<>()
//		);
//	}
	

}

