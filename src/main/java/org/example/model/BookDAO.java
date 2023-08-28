package org.example.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    // DAO(Class)-JDBC -> Mapper(Interface)-Mybatis -> Repository(interface)-JPA
    // Connection POOL : HikariCP
    private Connection conn;
    private Statement st;
    private PreparedStatement ps; // sql 문장에 파라미터가 있는 경우 사용
    private ResultSet rs;

    public void getConnection() {
        String url = "jdbc:mysql://localhost:3306/fcampus";
        String username = "root";
        String password = "12345";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //저장 기능
    public int bookRegister(BookVO book) {
        String query = "insert into tblbook(title,company,writer,price) values(?,?,?,?)";
        getConnection();
        int cnt = -1;
        try {
            ps = conn.prepareStatement(query); // 미완성 sql을 미리 컴파일 시켜서 받는다.
            //ps는 컴파일 된 sql을 갖고 있다.
            ps.setString(1, book.getTitle()); // 여기선 값만 넣는다.
            ps.setString(2, book.getCompany());
            ps.setString(3, book.getWriter());
            ps.setInt(4, book.getPrice());
            cnt = ps.executeUpdate(); // 컴파일을 위에서 했기 때문에 컴파일 하지 않고 실행한다.
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return cnt;
    }

    public List<BookVO> bookList() {
        String query = "select * from tblbook";
        getConnection();
        List<BookVO> bookList = new ArrayList<>();
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                BookVO book = new BookVO();
                book.setNum(rs.getInt("num")); //컬럼 명(column label)을 적어도 되고 컬럼의 인덱스(column index)를 적어도 된다. 즉 num이나 1를 쓸 수 있다.
                //하지만 소스코드를 보면 뭘 가르키는지 잘 모르니깐 컬럼 명으로 적는다.

                book.setCompany(rs.getString("company"));
                book.setWriter(rs.getString("writer"));
                book.setPrice(rs.getInt("price"));
                bookList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return bookList;
    }

    public void dbClose() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
