package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver getWebDriver() throws IOException {

		if (driver == null) {
			FileInputStream fileInputStream = new FileInputStream(
					new File(System.getProperty("user.dir") + "\\src\\test\\resources\\globalProperties.properties"));
			Properties properties = new Properties();
			properties.load(fileInputStream);
			String url = properties.getProperty("url");
			String browser = (null == System.getProperty("browser")) ? properties.getProperty("browser") :System.getProperty("browser") ;
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
			if ("chrome".equalsIgnoreCase(browser)) {
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get(url);
			}
		}
		return driver;
	}

}
