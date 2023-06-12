package ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorEX1 {
	public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.title;";
		String title = (String) js.executeScript(script);
		System.out.println(title);
		
		driver.switchTo().frame(0);
		js.executeScript("myFunction()");
		driver.switchTo().alert().accept();
		
		WebElement element = driver.findElement(By.xpath("//button[text()='Try it']"));
		js.executeScript("arguments[0].style.border='5px solid green'", element);
		
		driver.navigate().to("https://www.w3schools.com/");
		WebElement elem = driver.findElement(By.linkText("HTML Reference"));
		js.executeScript("arguments[0].scrollIntoView(true);", elem);

	}

}
