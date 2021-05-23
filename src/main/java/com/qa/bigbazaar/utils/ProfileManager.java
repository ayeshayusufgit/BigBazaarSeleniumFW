package com.qa.bigbazaar.utils;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ProfileManager {
	private Properties prop;
	private ChromeOptions chromeOptions;
	private FirefoxOptions firefoxOptions;

	public ProfileManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		chromeOptions = new ChromeOptions();
		System.out.println(prop.get("headless"));
		if (prop.getProperty("headless").trim().equals("true")) {
			chromeOptions.addArguments("--headless");
		}

		System.out.println(prop.get("incognito"));
		if (prop.getProperty("incognito").trim().equals("true")) {
			chromeOptions.addArguments("--incognito");
		}
		return chromeOptions;
	}

	public FirefoxOptions getFirefoxOptions() {
		firefoxOptions = new FirefoxOptions();
		if (prop.getProperty("headless").trim().equals("true")) {
			firefoxOptions.addArguments("--headless");
		}
		if (prop.getProperty("incognito").trim().equals("true")) {
			firefoxOptions.addArguments("--incognito");
		}
		return firefoxOptions;
	}
}
