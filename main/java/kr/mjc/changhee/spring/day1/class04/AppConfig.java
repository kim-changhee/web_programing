package main.java.kr.mjc.changhee.spring.day1.class04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 1개이상의 Bean을 등록하고 있다고 명시하는 것
public class AppConfig {

    @Bean
    public SonySpeaker sonySpeaker() {
        return new SonySpeaker();
    }

    @Bean
    public AppleSpeaker appleSpeaker() {
        return new AppleSpeaker();
    }

    /**
     * Constructor-based dependency injection
     */
    @Bean
    public SamsungTV samsungTV() {
        return new SamsungTV(sonySpeaker());
    }

    /**
     * Setter-based dependency injection
     */
    @Bean
    public LgTV lgTV() {
        LgTV lgTV = new LgTV();
        lgTV.setSpeaker(appleSpeaker());
        return lgTV;
    }
}
