package main.java.kr.mjc.changhee.spring.day1.class04.componentscan;

import org.springframework.stereotype.Component;

@Component
public class SonySpeaker implements Speaker{
    public SonySpeaker() {
        System.out.println("sonySpeaker instance is created.");
    }
}
