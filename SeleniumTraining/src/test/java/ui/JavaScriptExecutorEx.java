package ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorEx {
public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
		//Print the title
		String script = "return document.title;";
		String title = (String) js.executeScript(script);
		System.out.println(title);

		//click button
		driver.switchTo().frame(0);
		js.executeScript("myFunction()");
		driver.switchTo().alert().accept();
		
		//highlighting the button
		WebElement element = driver.findElement(By.xpath("//button[text()='Try it']"));
		js.executeScript("arguments[0].style.border='5px solid blue'", element);
		
		//scroll the page
		driver.navigate().to("https://www.w3schools.com/");
		WebElement element1 = driver.findElement(By.linkText("Learn How To"));
		js.executeScript("arguments[0].scrollIntoView(true);", element1);
		
		driver.close();
		
	}

}
