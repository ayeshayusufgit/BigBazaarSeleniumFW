package com.qa.bigbazaar.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtil {
	WebDriver driver;

	public WebDriverUtil(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void browserMaximize() {
		driver.manage().window().maximize();
	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public String getPageTitle() {
		return driver.getTitle();

	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}
}
