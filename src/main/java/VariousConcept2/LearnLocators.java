package VariousConcept2;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnLocators {
WebDriver driver;
@Before
public void init() {
	//user.dir
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\dhart\\selenium\\1st_Selenium\\driver\\chromedriver.exe");
	//System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
	//System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
	
	System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	//driver.get("https://www.selenium.dev/");
	driver.get("https://techfios.com/billing/?ng=dashboard/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}
//@Test
 public void learnDifferentLocators() {
	 driver.findElement(By.linkText("Charity supporting the Ukrainian army")).click();
	 driver.findElement(By.partialLinkText("Save the Children")).click();
	 
 }
@Test
public void DifferentLocators() {
	driver.findElement(By.cssSelector("input#username")).sendKeys("demo@techfios.com");
	driver.findElement(By.cssSelector("input[type='password']")).sendKeys("abc123");
	//driver.findElement(By.cssSelector("input[type='password'][placeholder='Password][name='password']")).sendKeys("abc123");
  
	//Absolute X path
	driver.findElement(By.xpath("html/body/div/div/div/form/div[3]/button")).click();
	
	//Relative Xpath
	//you can use any of line 46,47,or 49 to click login (sign in )button.
	//driver.findElement(By.xpath("//button[@name= 'login']")).click();
	//driver.findElement(By.xpath("//button[@name= 'login' and @type='submit']")).click();
	
	
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	//driver.findElement(By.xpath("//a[contains)).click();
	driver.findElement(By.xpath("//span[text()='Customers']")).click();
	//use webdriverwait to some more time to run next program.
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Customers']"))));
	driver.findElement(By.xpath("//a[contains(text(), 'Add Customer')]")).click();
}
}
