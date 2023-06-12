package ui;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyEventPractice {
public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://extendsclass.com/text-compare.html");

		WebElement srcTxtArea = driver.findElement(By.xpath("(//div[@class='CodeMirror-sizer'])[1]"));
		WebElement destTxtArea = driver.findElement(By.xpath("(//div[@class='CodeMirror-sizer'])[2]"));
		
		Actions a = new Actions(driver);
		a.keyDown(srcTxtArea, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		a.keyDown(destTxtArea, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/aws.png");
		FileUtils.copyFile(src, dest);
	}

}
