package main.java.kr.mjc.changhee.spring.day1.class03;


import main.java.kr.mjc.changhee.spring.day1.class02.LgTV;
import main.java.kr.mjc.changhee.spring.day1.class02.SamsungTV;
import main.java.kr.mjc.changhee.spring.day1.class02.TV;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public TV samsungTV() {
        return new SamsungTV();
    }

    @Bean
    public TV lgTV() {
        return new LgTV();
    }
}
