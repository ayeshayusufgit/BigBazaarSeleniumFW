package com.qa.bigbazaar.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.bigbazaar.base.BaseTest;
import com.qa.bigbazaar.utils.Constants;

public class HomePageTest extends BaseTest {


	@Test(priority = 1)
	public void loginTest() {
		homePage.doLogin(prop.getProperty("mobile"), prop.getProperty("otp"));
		Assert.assertTrue(homePage.isUserLoggedInElementPresent());
		//searchPage=homePage.doSearch2("Apple");
	}
	
	@Test(priority = 2)
	public void homePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page Title is:" + title);
		//Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

}
