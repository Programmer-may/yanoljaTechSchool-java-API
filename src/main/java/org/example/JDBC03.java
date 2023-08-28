package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/fcampus";
        String username = "root";
        String password = "12345";

        int num =2;
        String query = "delete from tblbook where num="+num;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username,password);

            // 삭제
            // ORM - Hibernate (sql 쿼리를 쓰지 않고도 관리 가능)

            Statement st = conn.createStatement();
            int cnt = st.executeUpdate(query);
            if (cnt > 0) {
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");
            }


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
