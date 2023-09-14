package kr.or.ddit.container;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitWebConfig(locations = "file:src/main/resources/kr/or/ddit/spring/conf/*-context.xml")
class RootContextTest {
	@Inject
	private DataSource dataSource;
	
	@Resource(name = "sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;

	@Test
	void test() throws SQLException {
		log.info("주입 객체 : {}", dataSource);
		log.info("connection : {}", dataSource.getConnection());
		log.info("sql session factory : {}", sqlSessionFactory);
	}

}















