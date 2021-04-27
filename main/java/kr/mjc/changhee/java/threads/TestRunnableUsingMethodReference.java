package main.java.kr.mjc.changhee.java.threads;

public class TestRunnableUsingMethodReference {
    public static void main(String[] args) {
        new Thread(new TestRunnableUsingMethodReference()::doSomething).start();
    }

    public void doSomething() {
        for (int i = 0; i < 4; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);  // 1000ms(1초) 동안 휴식
            } catch (InterruptedException e) {
            }
        }
    }
}
