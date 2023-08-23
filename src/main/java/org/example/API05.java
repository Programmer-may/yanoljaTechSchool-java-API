package org.example;

import com.google.gson.Gson;
import org.example.model.Book;
import org.example.model.BookList;

import java.io.FileReader;
import java.util.List;

public class API05 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("books2.json");
            Gson gson = new Gson();
            BookList bookList = gson.fromJson(fr, BookList.class);
            fr.close();

            List<Book> books = bookList.getBooks();
            for (Book b : books){
                System.out.println(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
