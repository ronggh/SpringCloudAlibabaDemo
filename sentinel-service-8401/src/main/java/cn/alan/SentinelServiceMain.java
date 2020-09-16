package cn.alan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author :Alan
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SentinelServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceMain.class, args);
    }
}
