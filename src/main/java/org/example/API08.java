package org.example;

public class API08 {
    public static void main(String[] args) {
        Thread t1 = Thread.currentThread();
                        //현재 스레드 객체 가져오기
        System.out.println(t1.getName());
                            // 이름 가져오기 : main
        System.out.println(t1.getPriority()); // 5
                            //우선순위 가져오기
        //우선 순위가 높으면 cpu의 시간을 더 많이 점유할 수 있다.
        t1.setPriority(Thread.MAX_PRIORITY); //우선순위 정하기
        // Thread.MAX_PRIORITY == 10
        //Thread.MIN_PRIORITY ==1
        //Thread.NORM_PRIORITY ==5
        //time slice

        // a~z까지 수를 출력하라
        // 1. 작업객체를 만든다.(job)
        Runnable target = new AlphaData();
        // 2. 스레드를 만든다(알바생)
        Thread alpa = new Thread(target); // 3. 스레드와 작업을 연결해준다. 생성자에 타겟 넣어준다.
        //4. 스레드를 시작한다.
        alpa.start(); //run()메소드를 실행시킨다. -> 스레드가 ready 상태-큐 자료구조에 들어감)


        //1~100까지의 수를 출력하시오
        try {
            for (int i = 1; i <= 100; i++) {
                System.out.print(i);
                Thread.sleep(1000); //1000 ->1sec
                //다른 스레드가 cpu의 시간을 얻을 수 있는 기회를 주는 것
                //문맥교환이 자주 일어나면 cpu 부하가 걸릴 수 있다.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
