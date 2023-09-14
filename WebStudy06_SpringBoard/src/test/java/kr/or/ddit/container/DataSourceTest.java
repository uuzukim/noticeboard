package kr.or.ddit.container;

import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitWebConfig(locations = "file:src/main/resources/kr/or/ddit/spring/conf/*-context.xml")
class DataSourceTest {

	@Inject
	private DataSource dataSource;
	@Inject
	private SqlSessionFactory factory;
	@Inject
	@Named("appInfo")
	private Properties appInfo;
	
	@Test
	void test() {
		log.info("주입된 dataSource : {}", dataSource);
		log.info("주입된 sqlSessionFactory : {}", factory);
		log.info("주입된 Properties : {}", appInfo);
	}

}












