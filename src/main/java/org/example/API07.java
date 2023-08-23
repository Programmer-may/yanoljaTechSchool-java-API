package org.example;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


// JVM -> main Thread
public class API07 {
    public static void main(String[] args) {
        // 특정 서버에 있는 자원(리소스)을 네트워킹을 이용해서 획득하기 - 크롤링

        String url = "https://sum.su.or.kr:8888/Themes/main/images/sub/audio_defaultimg.jpg";
        String imageName ="audio_defaultimg.jpg";

        HttpClient httpClient =  HttpClients.createDefault();
        //main Thread

        //이미지 다운로드 -> 별도의 Thread를 만들어서 처리
        DownloadBroker db = new DownloadBroker(url,imageName,httpClient);
        db.start();

        /*
        Runnable job = new DownloadBroker(url,imageName,httpClient);
        Thread t1 = new Thread(job);
        t1.start();
         */
        System.out.println("메인 스레드 종료");
    }
}
//JDBC -> Mybatis -> ORM(Hibernate) - > JPA
