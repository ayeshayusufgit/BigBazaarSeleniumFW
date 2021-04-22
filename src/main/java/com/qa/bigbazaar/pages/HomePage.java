package com.qa.bigbazaar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.bigbazaar.utils.Constants;
import com.qa.bigbazaar.utils.ElementUtil;

public class HomePage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By loginOverlay = By.cssSelector("div.loginModal");
	private By mobileNumberTextbox = By.cssSelector("input#mobileNumber");
	// private By loginButton=By.id("getpopOtp");
	private By loginButton = By.cssSelector("input#getpopOtp");
	private By otp1 = By.cssSelector("input#otp1");
	private By otp2 = By.cssSelector("input#otp2");
	private By otp3 = By.cssSelector("input#otp3");
	private By otp4 = By.cssSelector("input#otp4");
	private By continueButton = By.xpath("//button[contains(text(),'Continue')]");
	private By loggedInUserImage = By.cssSelector("div.loyality-imge-block img");
	private By searchTextbox = By.cssSelector("input#edc-search");
	private By searchSuggestionsOverlay = By.cssSelector("div#edc-search-static");
	private By searchViewAllLink = By.cssSelector("div.edc-SearchViewall");
	private By basketIcon = By.xpath("//div[@class='minicartImg']");
	private By myProfileIcon = By.xpath("//div[@class='loyality-imge-block']/img");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public boolean isHomePageURLPresent() {
		return elementUtil.waitForUrlToBe(Constants.HOME_PAGE_URL, 10);
	}

	public String getHomePageTitle() {
		return elementUtil.waitForTitleToBe(Constants.HOME_PAGE_TITLE, 5);
	}

	/*
	 * public boolean isBrandfactoryLogoPresent() { if
	 * (elementUtil.doIsDisplayed(brandFactoryLogo)) { return true; } return false;
	 * }
	 */

	public void doLogin(String mobile, String otp) {
		System.out.println("Entering mobile number:" + mobile + " otp:" + otp);
		elementUtil.waitForElementPresent(loginOverlay, 10);
		elementUtil.doSendKeys(mobileNumberTextbox, mobile);
		elementUtil.doClick(loginButton);
		elementUtil.waitForElementPresent(otp1, 10);
		elementUtil.doSendKeys(otp1, otp.charAt(0) + "");
		elementUtil.doSendKeys(otp2, otp.charAt(1) + "");
		elementUtil.doSendKeys(otp3, otp.charAt(2) + "");
		elementUtil.doSendKeys(otp4, otp.charAt(3) + "");
		elementUtil.doClick(continueButton);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isUserLoggedInElementPresent() {
		elementUtil.waitForElementPresent(loggedInUserImage, 10);
		if (elementUtil.doIsDisplayed(loggedInUserImage))
			return true;
		return false;
	}

	public SearchPage doSearch1(String searchTerm) {
		System.out.println("Searching for:" + searchTerm);
		elementUtil.doClick(searchTextbox);
		elementUtil.doSendKeys(searchTextbox, searchTerm);
		elementUtil.waitForElementPresent(searchSuggestionsOverlay, 10);
		elementUtil.waitForElementPresent(searchViewAllLink, 10);
		elementUtil.doClick(searchViewAllLink);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SearchPage(driver);
	}

	public SearchPage doSearch2(String searchTerm) {
		System.out.println("Searching for:" + searchTerm);
		elementUtil.doClick(searchTextbox);
		elementUtil.doSendKeys(searchTextbox, searchTerm);
		elementUtil.doSendKeys(searchTextbox, Keys.ENTER);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SearchPage(driver);
	}

	public EmptyBasketPage clickOnBasketIcon() {
		elementUtil.doClick(basketIcon);
		return new EmptyBasketPage(driver);
	}

	public MyProfilePage clickMyProfileIcon() {
		elementUtil.clickWhenReady(myProfileIcon, 10);
		return new MyProfilePage(driver);
	}

}
