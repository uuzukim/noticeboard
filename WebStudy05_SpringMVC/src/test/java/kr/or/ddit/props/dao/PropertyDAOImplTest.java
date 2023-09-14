package kr.or.ddit.props.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.AbstractRootTest;
import kr.or.ddit.vo.PropertyVO;

@Transactional
class PropertyDAOImplTest extends AbstractRootTest{
	
	@Inject
	private PropertyDAO dao;

	@Test
	void testInsertProperty() {
		PropertyVO prop = new PropertyVO();
		prop.setPropertyName("nonCommitPN99");
		prop.setPropertyValue("nonCommitPV99");
//		prop.setDescription("nonCommitDS");
		int cnt = dao.insertProperty(prop);
		assertEquals(1, cnt);
	}

	@Test
	void testSelectProperty() {
		PropertyVO prop = dao.selectProperty("nonCommitPN");
		assertNotNull(prop);
	}

	@Test
	void testSelectProperties() {
		dao.selectProperties().forEach(System.out::println);
	}

	@Test
	void testUpdateProperty() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteProperty() {
		int cnt = dao.deleteProperty("nonCommitPN");
		assertNotEquals(0, cnt);
	}

}













