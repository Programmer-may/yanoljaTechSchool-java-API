package org.example;

import org.example.model.BookDAO;
import org.example.model.BookVO;

import java.util.List;

public class JDBC08 {
    public static void main(String[] args) {
        //수정 기능

        // 클라이언트로부터 넘어온 데이터 (폼 파라미터)
        int num =5;
        String company = "대림출판사";
        String writer = "홍길동";
        int price = 42000;


        // 파라미터를 수집 한다.
        BookVO book = new BookVO();
        book.setNum(num);
        book.setCompany(company);
        book.setWriter(writer);
        book.setPrice(price);
        // 나중에 스프링에선 자동으로 수집해준다.

        BookDAO dao = new BookDAO();
        int cnt = dao.bookUpdate(book);
        if(cnt>0){
            System.out.println("수정 성공");
            List<BookVO> bookList = dao.bookList();
            if (bookList.size() != 0) {
                for (BookVO b : bookList) {
                    System.out.println(b);
                }
            }
        } else {
            System.out.println("수정 실패");
        }
    }
}
