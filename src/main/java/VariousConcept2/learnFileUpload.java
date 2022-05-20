package VariousConcept2;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class learnFileUpload {
	
	WebDriver driver;
	@Before
	 public void init() {
	  
	  System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.get("https://objectspy.space/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  
	 }
	@Test
	//use sendkeys method to upload as long as the tag is input.
	//any other tags you'll have to use Robot class
	public void learnFileUpload() {
		driver.findElement(By.xpath("//*[@id=\"photo\"]")).sendKeys("C:\\Users\\dhart\\Desktop\\Java-oop-cheat-sheet.pdf");
		
	}

}
