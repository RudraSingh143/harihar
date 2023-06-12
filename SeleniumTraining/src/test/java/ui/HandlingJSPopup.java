package ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingJSPopup {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		  driver.get("https://demo.automationtesting.in/Alerts.html");
		  driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
		  String text = driver.switchTo().alert().getText();
		  System.out.println(text);
		  driver.switchTo().alert().accept();
		  driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
		  driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		  driver.switchTo().alert().dismiss();
		  driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
		  driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		  driver.switchTo().alert().sendKeys("Rudra");
		  Thread.sleep(3000);
		  driver.switchTo().alert().accept();
		  
	}

}
