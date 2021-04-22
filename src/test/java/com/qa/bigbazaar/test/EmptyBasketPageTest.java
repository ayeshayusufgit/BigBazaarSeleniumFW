package com.qa.bigbazaar.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bigbazaar.base.BaseTest;
import com.qa.bigbazaar.utils.Constants;

public class EmptyBasketPageTest extends BaseTest {

	@BeforeClass
	public void basketPageSetup() {
		homePage.doLogin(prop.getProperty("mobile"), prop.getProperty("otp"));
		emptybasketPage = homePage.clickOnBasketIcon();
	}

	@Test(priority = 1)
	public void testEmptyBasketPageTitle() {
		Assert.assertTrue(emptybasketPage.getBasketPageTitle().contains(Constants.BASKET_PAGE_TITLE));
	}
	
	
	@Test(priority = 2)
	public void testEmptyBasketPageStaticContent() {
		Assert.assertEquals(emptybasketPage.getEmptyBasketText(),Constants.EMPTY_BASKET_TEXT);
		Assert.assertEquals(emptybasketPage.getEmptyBasketImageSrc(),Constants.EMPTY_BASKET_IMAGE_PATH);
	}
	
	@Test(priority = 3)
	public void testPreviousPurchase() {
		Assert.assertEquals(emptybasketPage.checkPreviousPurchaseButton(),Constants.PREVIOUS_PURCHASE_URL);
	}
	
	
	@Test(priority = 4)
	public void testStartShoppingButton() {
		homePage=emptybasketPage.clickStartShoppingButton();
		Assert.assertTrue(homePage.isHomePageURLPresent());

	}

}
