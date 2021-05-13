package com.qa.bigbazaar.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author ayesha yusuf
 */
public class DriverFactory_Bac {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	public Properties prop;

	/**
	 * 
	 * @param browserName
	 * @return WebDriver reference on the bases of the given browser
	 * 
	 */

	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser");

		System.out.println("Browser name is:" + browserName);

		switch (browserName.trim()) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("chrome");
			} else {
				tlDriver.set(new ChromeDriver());
			}

			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("firefox");
			} else {
				tlDriver.set(new FirefoxDriver());
			}
			break;

		case "safari":
			tlDriver.set(new SafariDriver());
			break;

		default:
			System.out.println("Please pass the correct browser name:" + browserName);
			break;
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	public synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	public void init_remoteDriver(String browser) {

		if (browser.equals("chrome")) {
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability("browserName", "chrome");
			try {
				tlDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap));
				// tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("hubUrl")), cap));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (browser.equals("firefox")) {
			DesiredCapabilities cap =  DesiredCapabilities.firefox();
			cap.setCapability("browserName", "firefox");
			try {
				tlDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap));
				// tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("hubUrl")), cap));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method will initialize the properties from config.properties file
	 * 
	 */
	public Properties init_prop() {
		Properties prop = null;
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(fis);// inside the property file all the properties will be stored in the form of
							// Key/Value pairs, prop.load is used to load the properties
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String filePath = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		System.out.println(filePath);
		File dest = new File(filePath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}
}
