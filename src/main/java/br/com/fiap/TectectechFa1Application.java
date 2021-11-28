/**
 * Grupo Tec Tec Tech
 * Integrantes:
 * @author André Luiz Maia Tapioca Brenneisen	|| 	RM: 79922
 * @author Gabriel Domingues de Almeida 		||	RM: 83422
 * @author Giulianno Zanetti 					||	RM: 82126
 * @author Guilherme Hideki Takara Chalita 		||	RM: 82358
 * @author Marcos Lopes da Silva Junior 		||	RM: 82813
 */

package br.com.fiap;

import org.apache.catalina.Context;
import org.apache.tomcat.util.scan.StandardJarScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TectectechFa1Application {

	public static void main(String[] args) {
		SpringApplication.run(TectectechFa1Application.class, args);
	}
	
	@Bean
	public TomcatServletWebServerFactory tomcatFactory() {
		return new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				((StandardJarScanner) context.getJarScanner()).setScanManifest(false);
			}
		};
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("br.com.fiap.controller"))
	            .paths(PathSelectors.any())
	            .build();
	}

}
