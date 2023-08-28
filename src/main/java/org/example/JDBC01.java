package org.example;

//JDBC programming

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
// 자바에서 제공해주는 인터페이스를 사용하기 위해서 import 해줘야 한다.

public class JDBC01 {
    public static void main(String[] args) {
        // 1. Driver 설치 (api 다운을 말한다. pom.xml의 디펜던시 추가)
        //드라이버 타입이 여러가지 있다. odbc, 브릿지, 씬 등등

        // 2. 접속 url (프로토콜 + 서브 프로토콜)
        String url = "jdbc:mysql://localhost:3306/fcampus"; // 통신 규약 -프로토콜
        // 기본 프로토콜 -> jdbc:mysql://
        // 기본 프로토콜 뒤는 서브 프로토콜
        //3306 : mysql 포트번호

        // 3. 유저 네임과 패스워드
        String username = "root";
        String password = "12345";

        // 4. 드라이버를 메모리에 로딩하기 (mysql 드라이버 클래스를 메모리에 로딩. 즉 객체 생성)
        //DriverManager driver = new Driver(); // 정적 로딩 방법
        //자바의 부모 객체             //mysql에서 상속한 자식 객체

        String title = "파이썬";
        String company = "이지스";
        String writer = "김길동";
        int price = 23000;
        try {
            //DB는 종류가 많아 정적 로딩을 하지 않고 동적 로딩 방법을 쓴다.
            Class.forName("com.mysql.cj.jdbc.Driver");
            //컴파일러 시점에선 단순히 문자열로 인식한다.
            // 실행 시점에서 클래스 객체가 만들어진다.
            // 내부적으론 DriverManager driver = new com.mysql.cj.jdbc.Driver(); 로 된다.
            //문자열을 객체로 생성
            //자바기술 : reflection 기법 - 자바가 스프링 프레임 워크에서 자동으로 뭔가 해줄 수 있는 기법

            //DB 연결
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("연결성공");

            // 2. sql 문장 만들기
            String query = "insert into tblbook(title,company,writer,price) values('" + title + "','" + company + "','" + writer + "','" + price + "')";

            // 3. sql 문장을 전송할 전송객체를 생성 - Statement
            Statement st = con.createStatement();
            int cnt = st.executeUpdate(query); // 성공한 행의 갯수가 넘어온다
            if (cnt > 0) {
                System.out.println("입력성공");
            } else {
                System.out.println("입력실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally { // finally는 예외와 상관없이 무조건 실행
            // rs.close
            // st.close
            // conn.close
            //역순으로 close 해줘야 한다.
        }
        // db 프레임워크 까지 가면 우리가 할게 더 없어진다.
        //대신 api와 api끼리 어떻게 상호작용하는지 알아야한다.

    }
}
