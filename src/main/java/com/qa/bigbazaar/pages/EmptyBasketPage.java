package com.qa.bigbazaar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.bigbazaar.utils.ElementUtil;

public class EmptyBasketPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	By basketTitle = By.cssSelector("div.cartView div.cartTitle span");
	By emptyBasketImg = By.xpath("//div[@class='cartemptyChild']/img");
	By emptyBasketText = By.xpath("//div[@class='cartemptyChild']/p[1]");
	By previousPurchaseButton = By.xpath("//div[@class='cartemptyChild']//a[text()='Shop items from Previous orders']");
	By startShoppingButton = By.xpath("//div[@class='shoppingEmpty']");

	public EmptyBasketPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getBasketPageTitle() {
		elementUtil.waitForElementPresent(basketTitle, 10);
		return elementUtil.doGetText(basketTitle);
	}

	public String getEmptyBasketText() {
		return elementUtil.doGetText(emptyBasketText);
	}

	public String getEmptyBasketImageSrc() {
		return elementUtil.doGetAttribute(emptyBasketImg, "src");
	}

	public boolean isPreviousPurchaseButtonPresent() {
		elementUtil.waitForElementPresent(previousPurchaseButton, 10);
		if (elementUtil.doIsDisplayed(previousPurchaseButton))
			return true;

		return false;
	}

	public String checkPreviousPurchaseButton() {
		elementUtil.waitForElementPresent(previousPurchaseButton, 10);

		if (elementUtil.doIsDisplayed(previousPurchaseButton)) {
			System.out.println(elementUtil.doGetAttribute(previousPurchaseButton, "href"));
			return elementUtil.doGetAttribute(previousPurchaseButton, "href");
		}
		return null;
	}

	public HomePage clickStartShoppingButton() {
		elementUtil.clickWhenReady(startShoppingButton, 10);
		return new HomePage(driver);
	}
}
