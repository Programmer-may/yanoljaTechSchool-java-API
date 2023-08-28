package org.example;

import org.example.model.BookDAO;
import org.example.model.BookVO;

import java.util.List;

public class JDBC07 {
    public static void main(String[] args) {
        BookDAO dao = new BookDAO();
        List<BookVO> bookList = dao.bookList();
        if (bookList.size() != 0) {
            for (BookVO book : bookList) {
                System.out.println(book);
            }
        } else {
            System.out.println("데이터가 없습니다.");
        }
    }
}
