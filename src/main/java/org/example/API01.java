package org.example;

import org.example.model.Book;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class API01 {
    public static void main(String[] args) {
        /*
        객체(Object)를 문자열의 형태 (텍스트 형태)로 표현하는 방법
        여태까진 책을 : vo, dto 인 class로 만들었다.
        문자열의 형태로 만드는 방법은 json ,xml 형태로 표현할 수 있다.
        객체를 다른 네트워크 (파이썬 웹 서버 등) 보낼 수 없으니 binary 데이터인 텍스트 형태로 전송해야 한다.
        xml : 의미가 있는 태그,  Semantic 태그
        extension markup language - 사용자 확장 마크업 언어
        xml -dtd
        xml - Schema
        xml의 단점 : 태그가 들어가기 때문에 전송해야하는 데이터 양이 많아진다.
        장점 :  구체적인 정보를 적을 수 있다.



        의미를 살리면서 데이터 양을 줄이는 방안 -> json
        자료구조 map 처럼 "키" : "밸류" 처럼 되어있다.
        http://json.org

         */

        List<Book> books = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("책 제목 : (exit)");
            String input = scan.nextLine();
            if(input.equals("exit")) break;
            String title =input;

            System.out.println("책 출판사 : ");
            String company = scan.nextLine();

            System.out.println("책 저자 : ");
            String writer = scan.nextLine();

            System.out.println("책 가격 : ");
            int price = Integer.parseInt(scan.nextLine());

            //vo 구조에 묶어주고 list 구조에 담아주고
            books.add( new Book(title,company,writer,price));
        }
        scan.close();
        //List -> JSONArray
        //JSON API활용
        JSONArray booksArr = new JSONArray();
        for (Book book :books) {
            JSONObject bookObj = new JSONObject();
            bookObj.put("title",book.getTitle());
            bookObj.put("company",book.getCompany());
            bookObj.put("writer",book.getWriter());
            bookObj.put("price",book.getPrice());

            booksArr.put(bookObj);
        }
        JSONObject root = new JSONObject();
        root.put("books",booksArr);
        try {
            FileWriter fw = new FileWriter("book.txt");
            fw.write(root.toString(4)); // space bar 4개 만큼 들여쓰기하기
            fw.flush();
            fw.close();
            System.out.println("파일 생성 완료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
