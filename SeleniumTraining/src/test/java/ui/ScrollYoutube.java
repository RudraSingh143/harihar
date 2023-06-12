package ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollYoutube {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/watch?v=25U-KUpWd1c&list=PLL34mf651faPB-LyEP0-a7Avp_RHO0Lsm");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scroll(0,100)", "");
		Thread.sleep(10000);
		j.executeScript("document.querySelector(\"div[class='playlist-items style-scope ytd-playlist-panel-renderer']\").scrollTop=3000");
		Thread.sleep(5000);
		driver.close();
	}

}
