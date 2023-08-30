package org.example;

import org.example.model.BookVO;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JDBC12 {
    public static void main(String[] args) {
        // 자바 코드와 SQL 쿼리를 분리(xml)

        String url = "jdbc:mysql://localhost:3306/fcampus";
        String username = "root";
        String password = "12345";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = readSqlStatement("db.xml", "selectBooks");
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<BookVO> bookList = new ArrayList<>();
            while (rs.next()) {
                BookVO book = new BookVO();
                book.setNum(rs.getInt("num"));
                book.setTitle(rs.getString("title"));
                book.setCompany(rs.getString("company"));
                book.setWriter(rs.getString("writer"));
                book.setPrice(rs.getInt("price"));
                bookList.add(book);
            }
            if (bookList.size() != 0) {
                for (BookVO b : bookList) {
                    System.out.println(b);
                }
            } else {
                System.out.println("데이터 없음");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readSqlStatement(String fileName, String queryId) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                                                        //싱글톤 디자인 패턴 ,  단 한번 객체를 만든다.
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(fileName));
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            String expression = "/queries/select[@id='" + queryId + "']";
            Node node = (Node) xpath.evaluate(expression, document, XPathConstants.NODE);
            if (node != null) {
                return node.getTextContent().trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

// 이후에 java에서 sql 쿼리를 자동으로생성 - > Hibernate (ORM 기술 사용)
// save() -> Object(Member) -----> insert into table SQL ~
