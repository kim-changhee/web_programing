package main.java.kr.mjc.changhee.spring.day1.class04;


import main.java.kr.mjc.changhee.spring.day1.class02.TV;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVUserUsingJavaConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class);

        TV samsungTV = context.getBean("samsungTV",SamsungTV.class);
        samsungTV.volumeUp();
        TV lgTV = context.getBean(LgTV.class);
        lgTV.volumeDown();
    }
}
