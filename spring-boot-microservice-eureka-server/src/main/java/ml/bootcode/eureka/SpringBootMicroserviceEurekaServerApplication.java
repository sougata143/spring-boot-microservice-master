package ml.bootcode.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootMicroserviceEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceEurekaServerApplication.class, args);
	}

}

