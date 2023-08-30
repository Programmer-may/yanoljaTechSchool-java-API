package org.example;

import org.example.model.BookDAO;
import org.example.model.BookVO;

public class JDBC09 {
    public static void main(String[] args) {
        //특정 레코드 1개만 검색
        int num = 5;
        BookDAO dao = new BookDAO();
        BookVO book = dao.getByNum(num);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("검색 실패");
        }
    }
}
