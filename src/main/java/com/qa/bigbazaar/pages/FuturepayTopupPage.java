package com.qa.bigbazaar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.bigbazaar.utils.ElementUtil;
import com.qa.bigbazaar.utils.JavaScriptUtil;

public class FuturepayTopupPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	private JavaScriptUtil javaScriptUtil;

	By fpTitle = By.xpath("//div[@class='futurepay-heading']");
	By amountTextbox = By.id("amount");
	// By cvvTextbox = By.cssSelector("input[id^='savedcvv']");
	By ccNumberText = By.id("cardnumber");
	By ccDateText = By.id("cardDate");
	By ccCvvText = By.id("cvv");
	By ccNameText = By.id("cname");
	// By payButton = By.xpath("//button[contains(@id,'pay')]");
	By payButton = By.xpath("//button[@id='payBtn' and @class='text-center belowBtnBox payBtnActive']");

	public FuturepayTopupPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}

	public boolean getFPTopuPageURL() {
		return elementUtil.waitForUrlToBe("https://preprod-web.bigb.fgcommerce.net/futurepaytopup", 10);
	}

	public AxisSimulatorTopupPage fpRecharge(String topUpAmount, String cardNum, String cardExpiry, String cvv,
			String cardName) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		elementUtil.doSendKeys(amountTextbox, topUpAmount);
		// elementUtil.clickWhenReady(cvvTextbox, 10);
		// elementUtil.doSendKeys(cvvTextbox, cvv);
		// javaScriptUtil.sendKeysUsingJSWithName("savedcvv", cvv);
		enterCreditCardDetails(cardNum, cardExpiry, cvv, cardName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementUtil.clickWhenReady(payButton, 10);
		return new AxisSimulatorTopupPage(driver);
	}

	private void enterCreditCardDetails(String cardNum, String cardExpiry, String cvv, String cardName) {
		elementUtil.clickWhenReady(ccNumberText, 10);
		javaScriptUtil.sendKeysUsingJSWithId("cardnumber", cardNum);

		elementUtil.clickWhenReady(ccDateText, 10);
		javaScriptUtil.sendKeysUsingJSWithId("cardDate", cardExpiry);

		elementUtil.clickWhenReady(ccCvvText, 10);
		javaScriptUtil.sendKeysUsingJSWithId("cvv", cvv);

		elementUtil.clickWhenReady(ccNameText, 10);
		javaScriptUtil.sendKeysUsingJSWithId("cname", cardName);

		elementUtil.doClick(ccNumberText);
		elementUtil.doSendKeys(ccNumberText, Keys.TAB);

		elementUtil.doClick(ccDateText);
		elementUtil.doSendKeys(ccDateText, Keys.TAB);

		elementUtil.doClick(ccCvvText);
		elementUtil.doSendKeys(ccCvvText, Keys.TAB);

		elementUtil.doClick(ccNameText);
		elementUtil.doSendKeys(ccNumberText, Keys.TAB);

		elementUtil.doClick(ccNumberText);
		elementUtil.doSendKeys(ccNumberText, Keys.ARROW_LEFT);
	}

}
