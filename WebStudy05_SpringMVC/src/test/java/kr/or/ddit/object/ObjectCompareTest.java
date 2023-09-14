package kr.or.ddit.object;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.PropertyVO;

class ObjectCompareTest {

	@Test
	void test() {
		Object o1 = new Object();
		Object o2 = new Object();
		System.out.println(o1.hashCode());
		System.out.println(o2.hashCode());
		System.out.println(o1==o2);
		System.out.println(o1.equals(o2));
		
		PropertyVO p1 = new PropertyVO();
		PropertyVO p2 = new PropertyVO();
		
		p1.setPropertyName("a");
		p2.setPropertyName("a");
		
		p1.setPropertyValue("b");
		p2.setPropertyValue("c");
		
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
	}

}
