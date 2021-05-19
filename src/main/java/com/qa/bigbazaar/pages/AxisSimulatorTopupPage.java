package com.qa.bigbazaar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.bigbazaar.utils.ElementUtil;

import io.qameta.allure.Step;

public class AxisSimulatorTopupPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	By passwordTextbox = By.id("password");
	By payButton = By.id("submitBtn");
	By axisForm=By.id("formId");
	
	public AxisSimulatorTopupPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	@Step("Submit Axis Simulator Otp")
	public FuturepayPage submitOtp() {
		elementUtil.waitForTitleToBe("Axis Simulator", 10);
		elementUtil.clickWhenReady(passwordTextbox, 10);
		elementUtil.doSendKeys(passwordTextbox, "123456");
		elementUtil.doClick(payButton);
		return new FuturepayPage(driver);
	}
}
