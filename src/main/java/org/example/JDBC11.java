package org.example;

import org.example.model.BookDAO;
import org.example.model.BookRepository;
import org.example.model.BookVO;

import java.util.List;

public class JDBC11 {
    public static void main(String[] args) {
        // 특정 키워드로 검색
        String keyword = "자바";
        BookRepository repository = new BookDAO();
        List<BookVO> list = repository.getLikeBooks(keyword);
        if (!list.isEmpty()){
            for (BookVO b : list) {
                System.out.println(b);
            }
        } else {
            System.out.println("검색 정보 없음");
        }
    }
}
