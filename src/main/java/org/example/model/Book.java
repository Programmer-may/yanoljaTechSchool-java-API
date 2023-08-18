package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lombok API 써보기
@Data
@NoArgsConstructor //명시적으로 기본생성자 만들기
@AllArgsConstructor
public class Book {
    private String title;
    private String company;
    private String writer;
    private int price;
}
