package com.qa.bigbazaar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.bigbazaar.utils.ElementUtil;
import com.qa.bigbazaar.utils.JavaScriptUtil;

public class FuturepayPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	private JavaScriptUtil javaScriptUtil;

	By fpTitle = By.xpath("//div[@class='futurepay-heading']");
	By fpAddMoneyButton = By.xpath("//div[@class='futurepay-Btn']");
	By fpTopupSuccessOverlay = By.xpath("//div[@class='mobile-message']");
	By fpTopupSuccessMessage = By.xpath("(//div[@id='displayPopupCustomMsg'])[3]");
	By fpNewToppedValue = By.xpath("//span[@class='priceStyle']");

	public FuturepayPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}

	public String getFPPageTitle() {
		elementUtil.waitForElementVisible(fpTitle, 10);
		if (elementUtil.doIsDisplayed(fpTitle)) {
			return elementUtil.doGetText(fpTitle);
		}
		return null;
	}

	public FuturepayTopupPage clickAddMoneyButton() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementUtil.doClick(fpAddMoneyButton);
		return new FuturepayTopupPage(driver);
	}

	public String getFpTopupSuccessMesssage() {
		/*
		 * elementUtil.waitForElementVisible(fpTopupSuccessMessage, 10); if
		 * (elementUtil.doIsDisplayed(fpTopupSuccessMessage)) { return
		 * elementUtil.doGetText(fpTopupSuccessMessage); } return null;
		 */
		// elementUtil.waitForElementPresent(fpTopupSuccessMessage, 10);
		elementUtil.waitForElementPresent(fpTopupSuccessMessage, 10);
		return elementUtil.doGetAttribute(fpTopupSuccessMessage, "innerHTML");
	}

	public double getFpToppedUpValue() {
		elementUtil.waitForElementVisible(fpNewToppedValue, 10);
		double toppedValue=0.0;
		if (elementUtil.doIsDisplayed(fpNewToppedValue))
			toppedValue=Double.parseDouble(elementUtil.doGetText(fpNewToppedValue).replaceAll("[^\\d.]", "").trim());
		return toppedValue;
	}
}
