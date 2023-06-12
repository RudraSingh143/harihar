package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllLinks {
	
	public static void main(String[] args) {
		//WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//WebDriverManager.firefoxdriver().setup();
		//FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int count = allLinks.size();
		System.out.println(count);
		for(int i=0;i<count;i++) {
			String text = allLinks.get(i).getText();
			System.out.println(text);
		}
		driver.close();
	}

}
