package main.java.kr.mjc.changhee.spring.day1.class03;


import main.java.kr.mjc.changhee.spring.day1.class02.LgTV;
import main.java.kr.mjc.changhee.spring.day1.class02.SamsungTV;
import main.java.kr.mjc.changhee.spring.day1.class02.TV;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVUserUsingComponentScan {

    public static void main(String[] args) {

        // @ComponentScan의 basePackage에서 @Component로 정의된 빈들을 생성
        // Java-based configuration에서 component scan
        ApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfigUsingComponentScan.class);

        // XML-based configuration에서 component scan
        // ApplicationContext context = new ClassPathXmlApplicationContext(
        // "applicationContext03-cs.xml");

        TV samsungTV = context.getBean(SamsungTV.class);
        samsungTV.powerOn();
        samsungTV.powerOff();

        TV lgTV = context.getBean(LgTV.class);
        lgTV.powerOn();
        lgTV.powerOff();
    }
}
