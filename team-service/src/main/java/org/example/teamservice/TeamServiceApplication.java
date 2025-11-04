package org.example.teamservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  // Pour s'enregistrer auprès d'Eureka
public class TeamServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamServiceApplication.class, args);
    }
}