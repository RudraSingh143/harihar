package ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {
	 public static WebDriver driver;
		public static void main(String[] args) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://jqueryui.com/slider/#colorpicker");
			driver.switchTo().frame(0);
			WebElement slide = driver.findElement(By.id("green"));
			
			Actions action = new Actions(driver);
			action.dragAndDropBy(slide, 100, 125).perform();
			driver.close();
			
	}

}
