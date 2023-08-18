package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;

public class API02 {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("book.txt");
            StringBuilder jsonString = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1) {
                jsonString.append((char) character);
            }
            reader.close();
            JSONObject jsonObject = new JSONObject(jsonString.toString());
            JSONArray booksArray = jsonObject.getJSONArray("books");
            for (int i = 0; i < booksArray.length(); i++) {
                JSONObject bookObject = booksArray.getJSONObject(i);
                String title = bookObject.getString("title");
                String company = bookObject.getString("company");
                String writer = bookObject.getString("writer");
                int price = bookObject.getInt("price");
                System.out.println("title: " + title);
                System.out.println("company: " + company);
                System.out.println("writer: " + writer);
                System.out.println("price: " + price);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //약국 검색하기
    //키워드로 위치 검색
    //카테고리로 장소 검색하기

    //network api
    //오픈 api 연결하기
    // HttpURLconnection  -----> 오픈 api와 연결
    // HttpClient
    //OkHttp
}
