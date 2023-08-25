package org.example;

public class AlphaData implements Runnable {

    @Override
    public void run() {
        try {
            for (char i = 'a'; i <= 'z'; i++) {
                System.out.print(i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
