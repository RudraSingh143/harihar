package ui;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindows {
 public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://secure.indeed.com");
		String windowhandle = driver.getWindowHandle();
		System.out.println(windowhandle);
		driver.findElement(By.id("apple-signin-button")).click();
		driver.findElement(By.id("login-facebook-button")).click();
		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);
		for(String wh : windowhandles) {
			driver.switchTo().window(wh);
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		}
        
	}

}
