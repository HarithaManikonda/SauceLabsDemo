package com.mytests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	WebDriver driver;
	@BeforeMethod
	public void setUp(String browserName) throws MalformedURLException
	{
		MutableCapabilities sauceOpts=new MutableCapabilities();
		//DesiredCapabilities caps=new DesiredCapabilities();
		sauceOpts.setCapability("build", "Java-W3C-Examples");
		sauceOpts.setCapability("seleniumVersion", "3.141.59");
		sauceOpts.setCapability("username", "oauth-haritha.manikonda-8aa1c");
		sauceOpts.setCapability("accessKey", "fea14705-5cac-49f3-a53f-2af72151cafc");
		sauceOpts.setCapability("tags", "w3c-chrome-tests");	

		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("sauce:options", sauceOpts);
		cap.setCapability("browserVersion", "latest");
		cap.setCapability("platformName", "windows10");

		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			cap.setCapability("browserName", "chrome");
		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			cap.setCapability("browserName", "firefox");
		}
		driver=new RemoteWebDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), cap);
	}
	@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
	
	

}
