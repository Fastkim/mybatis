package ch02.ex02;

import java.time.LocalDate;

import ch02.domain.User;

public interface Map { // mapper 객체를 만들었다 -> 클래스는 mybatis가 만들어주기때문
	User selectUser(int userId);
	User selectUser2(String userName);
	User selectUser3(LocalDate regDate);
}
