package org.example;

import org.example.model.BookVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBC05 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/fcampus";
        String username = "root";
        String password = "12345";

        // 번호가 1인 책 한권 조회
        String query = "select * from tblbook where num =1";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            BookVO book = null;
            if (rs.next()) {
                book = new BookVO();
                book.setNum(rs.getInt("num"));
                book.setCompany(rs.getString("company"));
                book.setWriter(rs.getString("writer"));
                book.setPrice(rs.getInt("price"));
            }
            if (book != null) {
                System.out.println(book);
            } else {
                System.out.println("Searched fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
