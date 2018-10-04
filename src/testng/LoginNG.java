package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginNG {
	public WebDriver driver;
	
	@BeforeMethod
	public void openapp()
	{
		System.setProperty("webdriver.chrome.driver","./software/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.infibeam.com/");
	}

	@Test
	public void loginto()
	{
		driver.findElement(By.id("loginlink")).click();	
		driver.findElement(By.id("userHandle")).sendKeys("bw25013@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Bruceinfibeam2018");
		driver.findElement(By.xpath("//div/button[.='LOGIN']")).click();
		SoftAssert s=new SoftAssert();
		String t=driver.getTitle();
		s.assertEquals(t, "Online Shopping India: Shop Mobiles, Books, Clothes, Shoes & More Online - Infibeam.com");
		Reporter.log(t,true);
		String url=driver.getCurrentUrl();
		Reporter.log(url);
		s.assertAll();
	}
	
	@AfterMethod
	public void closeapp()
	{
		driver.close();
	}
 }

