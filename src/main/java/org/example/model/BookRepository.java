package org.example.model;

import java.util.List;

public interface BookRepository {
    //  CRUD method 정의
    public int bookDelete(int num);
    public List<BookVO> getLikeBooks(String keyword);
}
