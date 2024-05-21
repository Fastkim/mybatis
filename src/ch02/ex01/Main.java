package ch02.ex01;

import java.util.List;

import ch02.domain.User;
import config.Configuration;

public class Main { // 실제 앱에서는 이 Main클래스가 Dao역할을 하게된다.
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
		
		List<User> users = mapper.selectUsers();
		users.forEach(System.out::println);
	}
}
