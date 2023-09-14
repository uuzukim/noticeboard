package kr.or.ddit.props;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.junit.jupiter.api.Test;

import kr.or.ddit.IndexController;

/**
 * * class path resource 검색 : ClassLoader
 * 
 *   A a = new A();
 *   A b = new A();
 *   
 *   properties 파일용 API : Properties, ResourceBundle 
 *
 */
class ResourceBundleTest {

	@Test
	void readTest() {
		
		String baseName = "kr.or.ddit.messages.Message";
		ResourceBundle bundle = ResourceBundle.getBundle(baseName, Locale.ENGLISH);
		Enumeration<String> keys = bundle.getKeys();
		while (keys.hasMoreElements()) {
			String msgCode = (String) keys.nextElement();
			String msg = bundle.getString(msgCode);
			System.out.printf(" %s : %s \n", msgCode, msg);
		}
	}

}




















