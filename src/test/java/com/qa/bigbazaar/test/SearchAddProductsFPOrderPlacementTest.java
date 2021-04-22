package com.qa.bigbazaar.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bigbazaar.base.BaseTest;
import com.qa.bigbazaar.utils.Constants;

public class SearchAddProductsFPOrderPlacementTest extends BaseTest {

	@BeforeClass
	public void basketPageSetup() {
		homePage.doLogin(prop.getProperty("mobile"), prop.getProperty("otp"));
		searchPage = homePage.doSearch1(prop.getProperty("searchTerm"));
		searchPage.addItems(1);
		basketPage = searchPage.navigateToBasketPage();
		checkoutPage = basketPage.clickProceedToPayment();
	}
	
	
	@Test(priority=1)
	public void testSearch() {

	}
	
	@Test(priority=2)
	public void testAddItems() {
		
	}

	@Test(priority = 1)
	public void testLoginVerifiedText() {
		Assert.assertEquals(checkoutPage.getMobileVerifiedText(), "Your mobile number is verified");
		Assert.assertEquals(checkoutPage.getMobileNumber(), prop.getProperty("mobile"));

	}

	@Test(priority = 2)
	public void testAddressText() {
		Assert.assertEquals(checkoutPage.getAddressTag(), "Home");
		Assert.assertNotNull(checkoutPage.getAddress());
	}

	@Test(priority = 3)
	public void testItemsAdded() {

	}

	@Test(priority = 4)
	public void testSelectDeliverySlot() {
		Assert.assertTrue(checkoutPage.checkItemImageInDeliverySlot());
		String selectedDeliveryDay=checkoutPage.getActiveDeliveryDay();
		checkoutPage.selectDeliverySlot(prop.getProperty("deliverySlot"));
		Assert.assertFalse(checkoutPage.checkItemImageInDeliverySlot());
		String selectedDeliverySlot=prop.getProperty("deliverySlot").replace("to", "-").trim();
		Assert.assertEquals(checkoutPage.getSelectedDeliverySlot(),selectedDeliveryDay+", "+selectedDeliverySlot);
	}

	@Test(priority = 5)
	public void testFPOrder() {
		orderSuccessPage = checkoutPage.makeFPOrder();
		Assert.assertTrue(orderSuccessPage.checkOrderPageURL());
		Assert.assertEquals(orderSuccessPage.getOrderPlacementText(), "Your order has been placed successfully!");
		Assert.assertEquals(orderSuccessPage.getPaymentMode(), "FuturePay");
		Assert.assertTrue(orderSuccessPage.checkPriceDetails());
	}
}
