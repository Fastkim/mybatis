package ch02.ex01;

import java.util.List;

import ch02.domain.User;

// mybatis는 밀키트와 같다. (물같은거는 따로 준비해야됑)
// map객체는 dao의 dependency가 된다.
public interface Map { // 이 interface의 자식클래스는 mybatis가 만들어주므로 껍데기(어떤메서드가 필요한지)만 만들어주면된다.
	List<User> selectUsers(); // 유지보수를 위해서 쿼리를 interface 바깥에 따로 만들어준다.
}
