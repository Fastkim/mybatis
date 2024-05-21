package ch02.ex03;

import java.time.LocalDate;

import org.apache.ibatis.annotations.Param;

import ch02.domain.User;

public interface Map {
	int insertUser(User user); // return 값이 0을 초과하는 값이면 성공, 0일경우 실패, 파라미터가 POJO인경우
	
	int insertUser2(@Param("userId")int userId, // @Param(파라미터이름) -> 파라미터이름 : sqlMap에서의 변수이름
			@Param("userName") String userName,
			@Param("regDate")LocalDate regDate);
	
	int insertUser3(int userId, String userName, LocalDate regDate); // index로 각각의 파라미터 구분
}
