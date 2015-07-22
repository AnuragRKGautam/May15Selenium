package com.mycompany.testUsingMaven;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMcAfeeLoginPage {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	
	//FirefoxDriver ffdriver= new FirefoxDriver();
	//private static Logger logger=Logger.getLogger(TestMcAfeeLoginPage.class);
	//String BaseUrl= "http://www.mcafee.com";
	
	@BeforeMethod
	public void setup() throws Exception
	{
		//ffdriver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
		//ffdriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		   driver = new FirefoxDriver();
		    baseUrl = "http://home.mcafee.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
		@Test
		public void testMcAfeeLoginPageTitle() throws Exception{
		//ffdriver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
			driver.get(baseUrl + "/Default.aspx?rfhs=1");
		    driver.findElement(By.xpath("//div[@id='homeBanner2014']/ul/li[3]")).click();
		    driver.findElement(By.linkText("Log In")).click();
		    driver.findElement(By.id("Password")).clear();
		    driver.findElement(By.id("Password")).sendKeys("test1234");
		    driver.findElement(By.id("btnLogin")).click();
		    driver.findElement(By.xpath("//div[@id='homeBanner2014']/ul/li[3]")).click();
		    driver.findElement(By.cssSelector("#ctl00_m_HeaderFullNavigation_ucDashBoardPersonalNav_hrefMyAccount > span")).click();
		}

	@AfterMethod
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    /*if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }*/
	  }


	private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

		  private boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }

		  private String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }
}
