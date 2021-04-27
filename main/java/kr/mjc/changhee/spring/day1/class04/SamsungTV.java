package main.java.kr.mjc.changhee.spring.day1.class04;


import main.java.kr.mjc.changhee.spring.day1.class02.TV;

public class SamsungTV implements TV {
    private final Speaker speaker;

    /**
     * speaker를 주입하는 컨스트럭터(생성자)
     */
    public SamsungTV(Speaker speaker) {
        this.speaker = speaker;
        System.out.println("samsungTV constructor에서 speaker를 넣었습니다.");
        System.out.println("samsungTV instance is created.");
    }

    @Override
    public void volumeUp() {
        System.out.print("samsungTV : ");
        speaker.volumeUp();
    }

    @Override
    public void volumeDown() {
        System.out.print("samsungTV : ");
        speaker.volumeDown();
    }
}
