package ui;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindows1 {
	 public static WebDriver driver;
		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://www.salesforce.com/in/?ir=1");
			driver.findElement(By.xpath("(//pbc-button[@class='cta_button'])[1]")).click();
			Set<String> windowHandels = driver.getWindowHandles();
			System.out.println(windowHandels);
			
			Iterator<String> iterator = windowHandels.iterator();
			String prntWindow = iterator.next();
			System.out.println(prntWindow);
			String childwindow = iterator.next();
			System.out.println(childwindow);
			
			driver.switchTo().window(childwindow);
			driver.findElement(By.name("UserFirstName")).sendKeys("Rudra");
			driver.findElement(By.name("UserLastName")).sendKeys("Singh");
			driver.switchTo().window(prntWindow);
			String title = driver.getTitle();
			System.out.println(title);
			driver.quit();
			
		}
}
