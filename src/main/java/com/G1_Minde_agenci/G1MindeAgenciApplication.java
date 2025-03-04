package com.G1_Minde_agenci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class G1MindeAgenciApplication {

	public static void main(String[] args) {
		SpringApplication.run(G1MindeAgenciApplication.class, args);
	}

}
