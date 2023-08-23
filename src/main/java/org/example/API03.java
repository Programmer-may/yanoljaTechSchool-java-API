package org.example;

import com.google.gson.Gson;
import org.example.model.Book;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class API03 {
    public static void main(String[] args) {
        //GSON API
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

        Gson gson = new Gson();
        String json = gson.toJson(books);
        System.out.println(json);
        try {
            FileWriter fw = new FileWriter("books1.json");
            fw.write(json);
            fw.close();
            System.out.println("파일 생성완료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
