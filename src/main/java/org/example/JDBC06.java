package org.example;

import org.example.model.BookDAO;
import org.example.model.BookVO;

import java.util.Scanner;

public class JDBC06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("책 제목 : ");
        String title = scan.nextLine();

        System.out.println("책 출판사 : ");
        String company = scan.nextLine();

        System.out.println("책 저자 : ");
        String writer = scan.nextLine();

        System.out.println("책 가격 : ");
        int price = Integer.parseInt(scan.nextLine());

        BookVO book = new BookVO(title, company, writer, price);

        BookDAO dao = new BookDAO();
        int cnt = dao.bookRegister(book);
        if (cnt > 0) {
            System.out.println("저장 성공");
        } else {
            System.out.println("저장 실패");
        }
    }
}
