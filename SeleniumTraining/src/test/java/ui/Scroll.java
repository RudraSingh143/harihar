package ui;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll {
	public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mdbootstrap.com/docs/b4/jquery/tables/scroll/");
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scroll(0,1000)", "");
		j.executeScript("document.querySelector(\"#dtVerticalScrollExample_wrapper > div:nth-child(2) > div > div > div.dataTables_scrollBody\").scrollTop=100");
		driver.close();
		
	}

}
