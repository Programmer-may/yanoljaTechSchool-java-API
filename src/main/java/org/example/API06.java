package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class API06 {
    public static void main(String[] args) {
        // 특정 서버에 있는 자원(리소스)을 네트워킹을 이용해서 획득하기 - 크롤링

        String url = "https://sum.su.or.kr:8888/bible/today";
        try {
            //요청 ------> 응답 : HTML(tag) API
            //Jsoup API : connection + pasrsing

            Document document = Jsoup.connect(url).get();
            //System.out.println(document);
            Element element = document.selectFirst("div.bible_text");
            if (element != null) {
                String text = element.text();
                System.out.println(text);
            }
            Elements body_list = document.select("ul.body_list > li");
            for (Element e : body_list) {
                System.out.print(e.selectFirst(".num").text() + " : ");
                System.out.println(e.selectFirst(".info").text());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
