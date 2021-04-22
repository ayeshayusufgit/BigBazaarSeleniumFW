package com.qa.bigbazaar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.bigbazaar.utils.ElementUtil;

public class MyProfilePage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	By fpBalance = By.xpath("//span[text()='Futurepay Wallet']/..//span[@class='listingTxtRight']");
	By fpWalletLink = By.xpath("//span[text()='Futurepay Wallet']");

	public MyProfilePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public double getActualFPBalance() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementUtil.waitForElementVisible(fpBalance, 10);
		double actualFPamount = 0.0;
		if (elementUtil.doIsDisplayed(fpBalance))
			actualFPamount = Double.parseDouble(elementUtil.doGetText(fpBalance).replaceAll("[^\\d.]", "").trim());
		return actualFPamount;
	}

	public String getFPDifferenceForTopup() {
		elementUtil.waitForElementVisible(fpBalance, 10);

		if (elementUtil.doIsDisplayed(fpBalance)) {
			System.out.println(elementUtil.doGetText(fpBalance));
			double fpAmount = Double.parseDouble(elementUtil.doGetText(fpBalance));
			double fpTopupAmount = 0.0;

			if (fpAmount < 1000) {
				fpTopupAmount = (1000 - fpAmount);
			} else {
				fpTopupAmount = fpAmount;
			}
			return fpTopupAmount + "";
		}
		return null;
	}

	public FuturepayPage clickFuturePayWallet() {
		elementUtil.waitForElementVisible(fpWalletLink, 10);
		elementUtil.doClick(fpWalletLink);
		return new FuturepayPage(driver);

	}

}
