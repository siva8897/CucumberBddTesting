package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestContextSetup {

	public static WebDriver driver;
	
	public static String Paranetwindow;

	public static void highlight(WebElement element) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].setAttribute('style','border:2px green solid;background:yellow');",
				element);
	}

}
