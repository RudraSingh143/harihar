package ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardEventsDemo {
	public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://extendsclass.com/text-compare.html");
		WebElement srcTxtArea = driver.findElement(By.xpath("(//div[@class='CodeMirror-sizer'])[1]"));
		
		Actions a = new Actions(driver);
		a.keyDown(srcTxtArea, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		WebElement destTxtArea = driver.findElement(By.xpath("(//div[@class='CodeMirror-sizer'])[2]"));
		a.keyDown(destTxtArea, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
	}

}
