package VariousConcept2;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class implicitWaitExplicitWait {
	WebDriver driver;

	@Before
//ImplicitWait:Dynamic,available for all the elements,it can be changed anytime,anywhere in your code

	public void implicitwait() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
	}

	@Test
	// ExplicitWait: dynamic,no explicit keyword or method available with
	// WebDriverWait and
	// it is specific to element,Available with webdriver with some Expected
	// conditions like visibilityof element,elementtobeclickable.
	public void Explicitwait() {
		WebElement firstname = driver.findElement(By.name("firstname"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(firstname)).sendKeys("peter");

		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
		wait.until(ExpectedConditions.visibilityOf(lastname)).sendKeys("smith");

		// ask shihab/
		
		WebElement gender = driver.findElement(By.xpath("//input[@id='u_4_2_4N'and@value='1']"));
		wait.until(ExpectedConditions.elementToBeClickable(gender)).click();
		
		driver.findElement(By.cssSelector("input[aria-label='Mobile number or email']")).sendKeys("12345");
	}

}
