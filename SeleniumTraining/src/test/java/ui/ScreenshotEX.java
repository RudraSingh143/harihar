package ui;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotEX {

	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.yatra.com");
		//driver.findElement(By.id("email")).sendKeys("9777882977");
		//driver.findElement(By.id("pass")).sendKeys("Krishna143");
		//driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		
		TakesScreenshot ss =  (TakesScreenshot) driver;
	    File src = ss.getScreenshotAs(OutputType.FILE);
	    File dest = new File("./screenshot/cd.png");
	    FileUtils.copyFile(src, dest);
	    
	}

}
