package com.qa.bigbazaar.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bigbazaar.base.BaseTest;
import com.qa.bigbazaar.utils.Constants;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void searchPageSetup() {
		homePage.doLogin(prop.getProperty("mobile"), prop.getProperty("otp"));
		searchPage = homePage.doSearch1(Constants.SEARCH_TERM);
		quickbuyPage = searchPage.clickItem();
		productInfoPage = quickbuyPage.clickViewMoreDetailsLink();
	}

	@Test(priority = 1)
	public void testAddItemFromPDP() throws InterruptedException {
		Assert.assertEquals(productInfoPage.getItemCount(), Constants.INITIAL_ITEM_COUNT);
		Assert.assertTrue(productInfoPage.addItems(Constants.ITEM_COUNT));
		Assert.assertEquals(productInfoPage.getItemCount(), Constants.ITEM_COUNT);
	}

	@Test(priority = 2)
	public void testRemoveItemsFromPDP() {
		Assert.assertEquals(productInfoPage.getItemCount(), Constants.ITEM_COUNT);
		productInfoPage.removeItems(Constants.ITEM_COUNT);
		Assert.assertEquals(productInfoPage.getItemCount(), Constants.INITIAL_ITEM_COUNT);
	}
}
