package main.java.kr.mjc.changhee.java.threads;

public class RestRoom {
    public void use() {
        synchronized (this) { // 최소한의 영역만 동기화를 한다.
            System.out.format("%s : 화장실에 들어갔다.\n", Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.format("%s : 화장실에서 나왔다.\n", Thread.currentThread().getName());
        }

        // 이 아래 부분은 동기화를 하지 않는다.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.format("%s : 손을 씻었다.\n", Thread.currentThread().getName());
    }
}
