package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// db와 앱을 연결하기 위한 jdbc 라이브러리 내의 클래스를 사용

public class Main {
	public static void main(String[] args) {
		final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		final String DB_USER = "mybatis";
		final String DB_PASSWORD = "mybatis"; // DB에 접속하는 환경설정은 유지보수를 위해 외부파일로 빼낸다.
		
		Connection conn = null; // 연결 객체
		PreparedStatement stmt = null; // SQL 명령문 실행 객체 준비
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // jdbc 개발자가 oracle하고 이렇게 연결하라고 정해놨다.
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // oracle로 request를 보내고, response를 받는다.
			
			String query = "SELECT user_id, user_name, reg_date FROM users"; // request 부분
			stmt = conn.prepareStatement(query); // sql을 준비하고
			rs = stmt.executeQuery(); // response를 받는다. resultSet은 table과 유사하다.
			// rs의 각각의 레코드를 객체로 만드는 과정
			
			// OR mapping (Object Relation) -> 여기서 Object을 POJO, 혹은 domain이라고 부른다.
			// mybatis는 or mapping 라이브러리에 관련한 프레임워크이다
			User user = null;
			while(rs.next()) { // row세상 : db , object세상 : java 연결
				// next에서 true가 return되면 row가 있고, false면 row가 없다.
				user = new User();
				user.setUserId(rs.getInt(1)); // getInt(1 : 첫번째 칼럼 불러오기)
				user.setUserName(rs.getString(2)); // varchar2 타입은 getString으로 읽으면됨.
				user.setRegDate(rs.getDate(3));
				
				System.out.println(user);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e) {}
		}
	}
}
