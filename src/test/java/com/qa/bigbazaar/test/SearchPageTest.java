package com.qa.bigbazaar.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bigbazaar.base.BaseTest;
import com.qa.bigbazaar.utils.Constants;

public class SearchPageTest extends BaseTest {

	@BeforeClass
	public void searchPageSetup() {
		homePage.doLogin(prop.getProperty("mobile"), prop.getProperty("otp"));
		searchPage = homePage.doSearch1(Constants.SEARCH_TERM);
		// searchPage.clickItem();

	}

	@Test(priority = 1)
	public void testSearchPageURL() {
		Assert.assertTrue(searchPage.isSearchPageURLPresent());
	}

	@Test(priority = 2)
	public void testSearchTermInBreadCrumb() {
		Assert.assertTrue(searchPage.getSearchTermFromBreadCrumb().equalsIgnoreCase(Constants.SEARCH_TERM));
	}

	@Test(priority = 3)
	public void testAddItemFromListings() throws InterruptedException {

		Assert.assertEquals(searchPage.getItemCount(), Constants.INITIAL_ITEM_COUNT);
		Assert.assertTrue(searchPage.addItems(Constants.ITEM_COUNT));
		Assert.assertEquals(searchPage.getItemCount(), Constants.ITEM_COUNT);
	}

	@Test(priority = 4, dependsOnMethods = "testAddItemFromListings")
	public void testRemoveItemsFromListings() {
		Assert.assertEquals(searchPage.getItemCount(), Constants.ITEM_COUNT);
		searchPage.removeItems(Constants.ITEM_COUNT);
		Assert.assertEquals(searchPage.getItemCount(), Constants.INITIAL_ITEM_COUNT);
	}

	@Test(priority = 5, dependsOnMethods = "testRemoveItemsFromListings")
	public void testQuickView() {
		searchPage.clickItem();
		Assert.assertTrue(searchPage.isQuickViewPresent());
	}
}
