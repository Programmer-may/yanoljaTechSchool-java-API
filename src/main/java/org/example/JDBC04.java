package org.example;

import org.example.model.BookVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC04 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/fcampus";
        String username = "root";
        String password = "12345";

        String query = "select * from tblbook";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username,password);

            //조회
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            //executeUpdate - 삽입, 수정, 삭제에서만 사용
            // select는 정보를 가져오는 거기때문에 executeQuery를 쓴다
            // 컬럼 이름을 포함한 모든 데이터를 result set 결과 집합이라 부른다.
            // result set 는 컬럼을 가르킨다.
            // 데이터가 있는지를 확인해 보기 위해서 rs를 뒤로 한칸 이동 시켜야한다. (첫번째 row를 가르키게)
            // 뒤로 한칸 넘기는게 rs.next() 이다.
            // rs를 커서라고 부르기도 한다.

            List<BookVO> bookList = new ArrayList<>();
            while ( rs.next()) {
                BookVO book = new BookVO();
                book.setNum(rs.getInt("num")); //컬럼 명(column label)을 적어도 되고 컬럼의 인덱스(column index)를 적어도 된다. 즉 num이나 1를 쓸 수 있다.
                //하지만 소스코드를 보면 뭘 가르키는지 잘 모르니깐 컬럼 명으로 적는다.

                book.setCompany(rs.getString("company"));
                book.setWriter(rs.getString("writer"));
                book.setPrice(rs.getInt("price"));
                bookList.add(book);
            }
            for (BookVO b : bookList) {
                System.out.println(b.toString());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
