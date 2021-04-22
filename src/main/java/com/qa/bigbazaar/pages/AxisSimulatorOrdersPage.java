package com.qa.bigbazaar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.bigbazaar.utils.ElementUtil;

public class AxisSimulatorOrdersPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	By passwordTextbox = By.id("password");
	By payButton = By.id("submitBtn");
	By axisForm=By.id("formId");
	
	public AxisSimulatorOrdersPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public OrderSuccessPage submitOtp() {
		elementUtil.waitForTitleToBe("Axis Simulator", 10);
		elementUtil.clickWhenReady(passwordTextbox, 10);
		elementUtil.doSendKeys(passwordTextbox, "123456");
		elementUtil.doClick(payButton);
		return new OrderSuccessPage(driver);
	}
}
