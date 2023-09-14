package kr.or.ddit.mybatis;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.PropertyVO;

class CustomSqlSessionFactoryBuilderTest {
	
	@Test
	void testSelect() {
		SqlSessionFactory factory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
		try(
			SqlSession sqlSession = factory.openSession();
		){
			List<PropertyVO> propList = sqlSession.selectList("kr.or.ddit.props.dao.PropertyDAO.selectProperties");
			assertNotNull(propList);
			assertNotEquals(0, propList.size());
			propList.forEach(System.out::println);
		}
	}

	@Test
	void test() {
		SqlSessionFactory factory1 = 
					CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
		SqlSessionFactory factory2 = 
				CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
		System.out.println(factory1 == factory2);
	}

}
