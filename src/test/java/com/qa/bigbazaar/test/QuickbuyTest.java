package com.qa.bigbazaar.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bigbazaar.base.BaseTest;
import com.qa.bigbazaar.utils.Constants;

public class QuickbuyTest extends BaseTest {

	@BeforeClass
	public void searchPageSetup() {
		homePage.doLogin(prop.getProperty("mobile"), prop.getProperty("otp"));
		searchPage = homePage.doSearch1(Constants.SEARCH_TERM);
		quickbuyPage=searchPage.clickItem();
	}
	@Test(priority = 1)
	public void testAddItemFromQuickbuy() throws InterruptedException {
		Assert.assertEquals(quickbuyPage.getItemCount(), Constants.INITIAL_ITEM_COUNT);
		Assert.assertTrue(quickbuyPage.addItems(Constants.ITEM_COUNT));
		Assert.assertEquals(quickbuyPage.getItemCount(), Constants.ITEM_COUNT);
	}

	@Test(priority = 2)
	public void testRemoveItemsFromQuickbuy() {
		Assert.assertEquals(quickbuyPage.getItemCount(), Constants.ITEM_COUNT);
		quickbuyPage.removeItems(Constants.ITEM_COUNT);
		Assert.assertEquals(quickbuyPage.getItemCount(), Constants.INITIAL_ITEM_COUNT);
	}

	@Test(priority = 3)
	public void testViewMoreDetailsFromQuickView() {
		productInfoPage = quickbuyPage.clickViewMoreDetailsLink();
		Assert.assertTrue(productInfoPage.getProductInfoPageURL().contains("productDetails"));
	}
}
