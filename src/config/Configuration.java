package config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Configuration {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("config/sqlMapConfig.xml"); // reader 객체가 환경설정을 파악
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader); // conn : 물리적인관점, session : 논리적인관점. 1개의 conncection의 n개의 session 가능
		}
	}
}
