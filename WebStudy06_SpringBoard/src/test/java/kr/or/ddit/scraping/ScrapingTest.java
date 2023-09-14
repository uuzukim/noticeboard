package kr.or.ddit.scraping;

import java.net.MalformedURLException;
import java.time.Duration;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import lombok.extern.slf4j.Slf4j;

/**
 * https://stackoverflow.com/questions/46920243/how-to-configure-chromedriver-to-initiate-chrome-browser-in-headless-mode-throug 참고
 *
 */
@Slf4j
class ScrapingTest {

	@Test
	void test() throws MalformedURLException {
		// hide browser window
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless=new");
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.get("https://www.saramin.co.kr/zf_user/jobs/list/domestic?loc_mcd=105000&panel_type=&search_optional_item=n&search_done=y&panel_count=y&preview=y");
		
		String title = driver.getTitle();
		
		log.info("Title : {}", title);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		
		Document doc = Jsoup.parse(driver.getPageSource());

		driver.quit();
		
        Elements elements = doc.select(".box_item");
        
        log.info("elements size : {}", elements.size());
        
        elements.stream().forEach(System.out::println);
	}

}
