package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	public WebDriver driver;

	// the below method id used to initialize the ThreadLocal driver basis on the
	// given driver

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver init_Driver(String browser) {
		System.out.println("The browser entered is:" + browser);
		//System.out.println("The url entered is:" + url);
		if (browser.equals("chrome")) {
			// driver=new ChromeDriver();
			tlDriver.set(new ChromeDriver());
			
		} else if (browser.equals("firefox")) {
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass the correct browser value" + browser);
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();

	}
	// Below method is used to get the driver with ThreadLocal

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();

	}

}
