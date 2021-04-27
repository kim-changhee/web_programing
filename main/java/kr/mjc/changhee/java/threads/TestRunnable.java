package main.java.kr.mjc.changhee.java.threads;

class TimerRunnable  implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);  // 1000ms(1초) 동안 휴식
            } catch (InterruptedException e) {
            }
        }
    }
}

public class TestRunnable {
    public static void main(String[] args) {
        Thread th = new Thread(new TimerRunnable());
        th.start();
    }
}
