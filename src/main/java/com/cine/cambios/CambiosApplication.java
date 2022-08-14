package com.cine.cambios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name="man-socios")
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class CambiosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CambiosApplication.class, args);
	}

}
