package com.qa.apphooks;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.utilities.configreader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
public class ApplicationHooks {

	private DriverFactory driverfactory;
	private WebDriver driver;
	private configreader configreader;
	Properties prop;
	


	@Before(order = 0)

	public void getproperty() throws IOException {
		configreader = new configreader();
		prop = configreader.init_prop();
	}

	@Before(order = 1)
	public void launchbrowser() {
		String browserrname = prop.getProperty("browser");
		
		String url=prop.getProperty("url");
		
		driverfactory = new DriverFactory();
		driver = driverfactory.init_Driver(browserrname);

	}

	@After(order = 0)
	public void quitbrowser() {
		driver.quit();
	}

	@After(order = 1)

public void teardown(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotname = scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotname);

		}
		else {
			String screenshotname = scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotname);
		

	}


	}
}
