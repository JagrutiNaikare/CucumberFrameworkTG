package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void SwitchWindowChild() {
		Set<String> openWindows = driver.getWindowHandles();
		Iterator<String> it = openWindows.iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);

	}
}
