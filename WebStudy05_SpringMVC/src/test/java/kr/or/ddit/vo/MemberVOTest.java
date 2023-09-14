package kr.or.ddit.vo;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kr.or.ddit.validate.groups.InsertGroup;

class MemberVOTest {
	private static Validator validator;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	void testGroup() {
		MemberVO target = new MemberVO();
//		target.setMemId("a001");
//		target.setMemPass("ja");
//		target.setMemMail("aa@naver.com");
//		target.setMemZip("333-333");
//		target.setMemAdd1("대전");
//		target.setMemAdd2("오류동");
//		target.setMemHp("000-000-0000");
//		target.setMemRegno1("123456");
//		target.setMemRegno2("1234567");
//		target.setMemName("이름");
		
		Set<ConstraintViolation<MemberVO>> violations = validator.validate(target, InsertGroup.class);
		boolean valid = violations.isEmpty();
		if(!valid) {
			Map<String, String> errors = new LinkedHashMap<>();
			violations.stream().forEach(sv->{
				String key = sv.getPropertyPath().toString();
				String value = sv.getMessage();
				errors.put(key, value);
				System.out.printf("%s : %s\n", key, value);
			});
		}
	}
	
	@Test
	void test() {
		MemberVO target = new MemberVO();
		target.setMemId("a001");
		target.setMemPass("ja");
		target.setMemMail("aa@naver.com");
		target.setMemZip("333-333");
		target.setMemAdd1("대전");
		target.setMemAdd2("오류동");
		target.setMemHp("000-000-0000");
		target.setMemRegno1("123456");
		target.setMemRegno2("1234567");
		target.setMemName("이름");
		
		Set<ConstraintViolation<MemberVO>> violations = validator.validate(target);
		boolean valid = violations.isEmpty();
		if(!valid) {
			Map<String, String> errors = new LinkedHashMap<>();
			violations.stream().forEach(sv->{
				String key = sv.getPropertyPath().toString();
				String value = sv.getMessage();
				errors.put(key, value);
				System.out.printf("%s : %s\n", key, value);
			});
		}
		assertNotEquals(true, valid);
	}

}




















