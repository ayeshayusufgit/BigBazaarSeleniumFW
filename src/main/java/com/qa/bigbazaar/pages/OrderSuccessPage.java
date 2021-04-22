package com.qa.bigbazaar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.bigbazaar.utils.ElementUtil;

public class OrderSuccessPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	private By mobileNumberTextbox = By.cssSelector("input#mobileNumber");
	private By orderPlacedText = By.xpath("//p[@class='orderTitleTxt']");
	private By orderIdText = By.xpath("//div[@class='Order-details-nr-date pull-right font-12']");
	private By itemTotalText = By.xpath("(//div[@class='Order-details-nr-hd pull-left'])[1]/following-sibling::*");
	private By discountText = By.xpath("(//div[@class='Order-details-nr-hd pull-left'])[2]/following-sibling::*");
	private By deliveryChargeText = By.xpath("(//div[@class='Order-details-nr-hd pull-left'])[3]/following-sibling::*");
	private By totalText = By.xpath("(//div[@class='Order-details-nr-hd pull-left'])[4]/following-sibling::*");
	private By totalSavingsText = By.xpath("(//div[@class='Order-details-nr-hd pull-left'])[5]/following-sibling::*");
	private By modeOfPaymentText = By.xpath("(//div[@class='Order-details-nr-hd pull-left'])[6]/following-sibling::*");

	public OrderSuccessPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public boolean checkOrderPageURL() {
		return elementUtil.waitForUrlToBe("https://preprod-web.bigb.fgcommerce.net/ordersuccess/", 30);
	}
	public String getOrderPlacementText() {
		elementUtil.waitForElementPresent(orderPlacedText, 10);
		if (elementUtil.doIsDisplayed(orderPlacedText))
			return elementUtil.doGetText(orderPlacedText);
		return null;
	}

	public String getPaymentMode() {
		elementUtil.waitForElementPresent(modeOfPaymentText, 10);
		if (elementUtil.doIsDisplayed(modeOfPaymentText))
			return elementUtil.doGetText(modeOfPaymentText);
		return null;
	}

	public boolean checkPriceDetails() {
		elementUtil.waitForElementPresent(orderIdText, 10);
		if (!(elementUtil.doGetText(orderIdText).isEmpty() && elementUtil.doGetText(itemTotalText).isEmpty()
				&& elementUtil.doGetText(discountText).isEmpty() && elementUtil.doGetText(deliveryChargeText).isEmpty()
				&& elementUtil.doGetText(totalText).isEmpty() && elementUtil.doGetText(totalSavingsText).isEmpty()
				&& elementUtil.doGetText(modeOfPaymentText).isEmpty())) {
			return true;
		}
		return false;
	}
}
