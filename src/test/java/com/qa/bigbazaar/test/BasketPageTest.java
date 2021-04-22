package com.qa.bigbazaar.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bigbazaar.base.BaseTest;
import com.qa.bigbazaar.utils.Constants;

public class BasketPageTest extends BaseTest{
	
	@BeforeClass
	public void basketPageSetup() {
		homePage.doLogin(prop.getProperty("mobile"), prop.getProperty("otp"));
		searchPage = homePage.doSearch1(prop.getProperty("searchTerm"));
		searchPage.addItems(1);
		basketPage=searchPage.navigateToBasketPage();
	}
	
	@Test(priority = 1)
	public void testBasketPageTitle() {
		Assert.assertTrue(basketPage.getBasketPageTitle().contains(Constants.BASKET_PAGE_TITLE));
	}
	
	@Test(priority=2)
	public void testItemsAddedInBasket() {
		
	}

	@Test(priority = 3)
	public void testProceedToPayment() {
		basketPage.clickProceedToPayment();
		Assert.assertEquals(checkoutPage.getCheckoutHeaderText(), "Kuch Bhi, Kahin Bhi, Kabhi Bhi");
	}
}
