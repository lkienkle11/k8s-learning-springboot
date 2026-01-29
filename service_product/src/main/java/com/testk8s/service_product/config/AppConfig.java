package com.testk8s.service_product.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        // Cấu hình timeout để tránh treo ứng dụng nếu API bên kia bị lỗi
        factory.setConnectTimeout(3000); // 3 giây
        factory.setReadTimeout(3000);    // 3 giây

        return new RestTemplate(factory);
    }
}