package kr.or.ddit.crypto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

class PasswordEncoderTest {
	
	private static PasswordEncoder passwordEncoder;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Test
	void test2() {
		String savedPass = "{bcrypt}$2a$10$NVfEvU51UMQLomlUbtT9wuDTRDCo2u5qP8YJRRs.H4y9cIewPJk7O";
		String inputPass = "java2";
		boolean authenticated = passwordEncoder.matches(inputPass, savedPass);
		System.out.println(authenticated);
		
	}
	
	@Test
	void test() {
		String plain = "java";
		String encoded = passwordEncoder.encode(plain);
		System.out.println(encoded);
	}

}
