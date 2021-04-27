package main.java.kr.mjc.changhee.spring.day1.class04.componentscan;

import main.java.kr.mjc.changhee.spring.day1.class02.TV;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUserUsingXmlConfig {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext04-cs.xml");

        TV samsungTV = context.getBean(SamsungTV.class);
        samsungTV.volumeUp();
        TV lgTV = context.getBean(LgTV.class);
        lgTV.volumeDown();
    }
}
