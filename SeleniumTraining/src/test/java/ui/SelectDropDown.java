package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDown {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(2000);
		WebElement mnthListBox = driver.findElement(By.id("month"));
		
		Select s = new Select(mnthListBox);
		s.selectByIndex(6);
		Thread.sleep(2000);
		s.selectByValue("8");
		Thread.sleep(2000);
		s.selectByVisibleText("May");
		
		
		
		
	}

}
