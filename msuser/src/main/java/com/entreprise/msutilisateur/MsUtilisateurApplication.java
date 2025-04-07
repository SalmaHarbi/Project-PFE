package com.entreprise.msutilisateur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication(scanBasePackages = "com.entreprise.msutilisateur")
@EnableDiscoveryClient
@EnableConfigurationProperties
@RefreshScope
public class MsUtilisateurApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsUtilisateurApplication.class, args);
    }

}
