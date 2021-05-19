package com.qa.bigbazaar.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.bigbazaar.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 200: BigBazaar WebApp Application Automation")
@Story("UserStory 201 : FuturePay Topup Feature testing")
public class AddFuturePayTest extends BaseTest {

	@BeforeClass
	public void homePageSetup() {
		homePage.doLogin(prop.getProperty("mobile"), prop.getProperty("otp"));
		myProfilePage = homePage.clickMyProfileIcon();
	}

	@Description("Verify the FuturePay Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1)
	public void futurepayTopupTest() {

		double fpActualAmount = myProfilePage.getActualFPBalance();
		futurepayPage = myProfilePage.clickFuturePayWallet();
		Assert.assertEquals(futurepayPage.getFPPageTitle(), "Future Pay Wallet");

		futurepayTopupPage = futurepayPage.clickAddMoneyButton();
		Assert.assertTrue(futurepayTopupPage.getFPTopuPageURL());

		axisTopupPage = futurepayTopupPage.fpRecharge(prop.getProperty("fpTopup"), prop.getProperty("cardNum"),
				prop.getProperty("cardExpiry"), prop.getProperty("cardCvv"), prop.getProperty("cardName"));
		futurepayPage = axisTopupPage.submitOtp();
		Assert.assertEquals(futurepayPage.getFpTopupSuccessMesssage(),
				"Future Pay Add balance Transaction Success &amp; Verified");
		Assert.assertTrue(futurepayPage.getFpToppedUpValue() > fpActualAmount);
	}
}
