package com.qa.bigbazaar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.bigbazaar.utils.ElementUtil;

public class BasketPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	By basketTitle = By.cssSelector("div.cartView div.cartTitle span");
	By proceedToPaymentButton = By.xpath("//div[@class='cart-checkout-button']");
	By itemAddedTitle = By.xpath("//span[contains(@class,'cart-module__cart-name')]");
	By itemAddedSize = By.xpath("//p[contains(@class,'cart-module__gray-txt')]");
	By itemAddedPrice = By.xpath("//span[contains(@class,'cart-module__memPricePlus')]");
	By itemAddedQuantity = By.xpath("//span[contains(@class,'cart-module__cartQty')]");
	By itemAddedMinus = By.xpath("//span[contains(@class,'cart-module__cartMinus')]");
	By itemAddedPlus = By.xpath("//span[contains(@class,'cart-module__cartPlus')]");

	public BasketPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getBasketPageTitle() {
		elementUtil.waitForElementPresent(basketTitle, 10);
		return elementUtil.doGetText(basketTitle);
	}

	public String getItemInBasketTitle() {
		elementUtil.waitForElementPresent(itemAddedTitle, 10);
		return elementUtil.doGetText(itemAddedTitle);
	}

	public String getItemInBasketSize() {
		elementUtil.waitForElementPresent(itemAddedSize, 10);
		return elementUtil.doGetText(itemAddedSize);
	}

	public String getItemInBasketPrice() {
		elementUtil.waitForElementPresent(itemAddedPrice, 10);
		return elementUtil.doGetText(itemAddedPrice);
	}

	public String getItemInBasketQuantity() {
		elementUtil.waitForElementPresent(itemAddedQuantity, 10);
		return elementUtil.doGetText(itemAddedQuantity);
	}

	public CheckoutPage clickProceedToPayment() {
		elementUtil.clickWhenReady(proceedToPaymentButton, 10);
		return new CheckoutPage(driver);
	}
}
