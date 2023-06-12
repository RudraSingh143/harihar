package ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingNotificationPopUp {
public static WebDriver driver;
  public static void main(String[]args) {
	  ChromeOptions option = new ChromeOptions();
	  option.addArguments("--disable-notifications");
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver(option);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	  driver.get("https://www.yatra.com");
	  driver.close();
			  
  }

}
