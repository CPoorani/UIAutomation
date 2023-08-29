package worktypegroups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Base {
	
	WebDriver driver;
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	String groupName = "Salesforce Automation";
	String editGroupName = "Automation";
	
	@BeforeMethod
	public void setUp()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.cssSelector("input.username")).sendKeys("pooranimenon5@gmail.com");
		driver.findElement(By.cssSelector("input.password")).sendKeys("Totest@123");
		driver.findElement(By.id("Login")).click();

	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
