package assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Jira {
	WebDriver driver;
	String summary = "Creating a new story";
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://api-training.atlassian.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	
	@Test
	public void createNewStory()
	{
		driver.findElement(By.xpath("//form[@id = 'form-login']//input[@id = 'username']"))
		.sendKeys("hari.radhakrishnan@testleaf.com");
		driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")).click();
		driver.findElement(By.xpath("//form[@id = 'form-login']//input[@id = 'password']")).sendKeys("India@123");
		driver.findElement(By.cssSelector("#login-submit")).click();
		driver.findElement(By.xpath("//div[@class = 'sc-1p2gpiw-0 jxAqSF']/a")).click();
		driver.findElement(By.xpath("//button[@id = 'createGlobalItem']/span")).click();
		driver.findElement(By.xpath("//input[@id = 'summary-field']")).sendKeys(summary);
		driver.findElement(By.xpath("//button[@type = 'submit']//span[text() = 'Create']")).click();
		driver.findElement(By.xpath("//span[text() = 'Backlog']")).click();
		driver.findElement(By.xpath("//input[@placeholder = 'Search backlog']")).sendKeys(summary);
		String getText = driver.findElement(By.xpath("//div[text() = 'Backlog']//following::mark")).getText();
		Assert.assertEquals(summary, getText);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
