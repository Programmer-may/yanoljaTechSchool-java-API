package org.example;
import java.sql.*;

public class JDBC02 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/fcampus";
        String username = "root";
        String password = "12345";

        int num =1;
        String name="박매일";
        int price = 50000;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username,password);
            // 후엔 따로 이 클래스를 만들어서 다루어야 한다. - DAO - Data Access Object

            // 수정 - num이 1인 책의 저자(박매일)와 가격(50000)을 수정하시오.
            // ORM - Hibernate (sql 쿼리를 쓰지 않고도 관리 가능)
            String query = "update tblbook set writer = '"+name+"', price = "+price+" where num="+num;
            Statement st = conn.createStatement();
            int cnt = st.executeUpdate(query);
            if (cnt > 0) {
                System.out.println("수정 성공");
            } else {
                System.out.println("수정 실패");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
