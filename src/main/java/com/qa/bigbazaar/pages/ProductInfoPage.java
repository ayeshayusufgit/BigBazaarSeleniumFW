package com.qa.bigbazaar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.bigbazaar.utils.Constants;
import com.qa.bigbazaar.utils.ElementUtil;
import com.qa.bigbazaar.utils.WebDriverUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	private WebDriverUtil webUtil;

	private By itemName = By.xpath("//div[@id='priceView']//h2");
	private By itemAddButton = By.xpath("//div[@class='pdp-cart']//span[@class='addbtn-new ripple']");

	private By itemAddPlusButton = By.xpath("//li[@class='qty-add ripple']");
	private By itemRemoveButton = By.xpath("//li[@class='qty-remove ripple']");
	private By itemCountText = By.cssSelector("div.minicartIcon.ripple em");

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public boolean addItems(int itemCount) {

		if (elementUtil.getElements(itemName).size() > 0) {
			elementUtil.waitForElementVisible(itemAddButton, 10);
			while (elementUtil.doIsDisplayed(itemAddButton)) {
				elementUtil.doClick(itemAddButton);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// elementUtil.waitForElementVisible(itemAddedToast, 10);
				break;
			}

			elementUtil.waitForElementVisible(itemAddPlusButton, 10);
			while (elementUtil.doIsDisplayed(itemAddPlusButton)) {
				for (int i = 2; i <= itemCount; i++) {
					elementUtil.doClick(itemAddPlusButton);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// elementUtil.waitForElementVisible(itemAddedToast, 10);
				}
				break;
			}
			return true;
		}
		return false;
	}

	public void removeItems(int itemCount) {
		elementUtil.waitForElementVisible(itemRemoveButton, 10);
		for (int i = itemCount; i >= 1; i--) {
			elementUtil.doClick(itemRemoveButton);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int getItemCount() {
		elementUtil.waitForElementVisible(itemCountText, 10);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Integer.parseInt(elementUtil.doGetText(itemCountText));
	}

	public String getProductInfoPageURL() {
		elementUtil.waitForUrlToBe(Constants.PRODUCT_PAGE_URL, 15);
		return webUtil.getPageUrl();
	}
}
