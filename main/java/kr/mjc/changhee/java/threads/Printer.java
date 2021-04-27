package main.java.kr.mjc.changhee.java.threads;

public class Printer {
    public synchronized void println(String str) {
        for (char c : str.toCharArray()) {
            System.out.print(c);
            try { // thread interference를 확인하기 위해 10ms의 휴식을 한다.
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
        System.out.print('\n');
    }
}
