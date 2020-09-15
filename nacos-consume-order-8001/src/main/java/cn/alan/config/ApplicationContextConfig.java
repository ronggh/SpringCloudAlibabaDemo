package cn.alan.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    /**
     * 启动两个nacos-provider-payment，一个在9001端口，一个在9002端口 注意要加上@LoadBalanced表示负载均衡
     * 
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
