package kr.or.ddit.props;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

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
class PropertiesTest {

	@Test
	void readTest() {
		String qualifiedName = "/kr/or/ddit/props/AlterDB.properties";
		try(
			InputStream is = IndexController.class.getResourceAsStream(qualifiedName);
		){
			Properties props = new Properties();
			props.load(is);
			
			props.forEach((k,v)->{
				System.out.printf(" %s : %s \n", k, v);
			});
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	void writeTest() {
		String qualifiedName = "/kr/or/ddit/props/AlterDB.properties";
		URL url = IndexController.class.getResource(qualifiedName);
		String realPath = url.getFile(); // real path
		File file = new File(realPath);
		try(
//			InputStream is = IndexServlet.class.getResourceAsStream(qualifiedName);
			FileOutputStream fos = new FileOutputStream(file);	
		){
			Properties props = new Properties();
//			props.load(is);
			props.setProperty("prop2", "prop value 2");
			props.store(fos, "임시 저장 프로퍼티");
			
//			props.forEach((k,v)->{
//				System.out.printf(" %s : %s \n", k, v);
//			});
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}




















