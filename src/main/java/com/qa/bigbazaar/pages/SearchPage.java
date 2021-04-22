package com.qa.bigbazaar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.bigbazaar.utils.Constants;
import com.qa.bigbazaar.utils.ElementUtil;
import com.qa.bigbazaar.pojos.Item;

public class SearchPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	Item itemObj;

	private By searchBreadCrumbContainer = By.cssSelector("ol.breadcrumb");
	private By searchTermInBreadCrumb = By.cssSelector("li.breadcrumb-item.active");
	private By itemAddButton = By.cssSelector("div.cartflag span.addbtn-new.ripple");
	private By itemAddPlusButton = By.cssSelector("li.qty-add.ripple");
	private By itemAddedToast = By.cssSelector("div.addedto-basket");
	private By itemCountText = By.cssSelector("div.minicartIcon.ripple em");
	private By itemLink = By.cssSelector("div.plpimage");
	private By itemRemoveButton = By.cssSelector("li.qty-remove.ripple");
	private By quickViewOverlay = By.cssSelector("div.quickView");
	private By itemAddQLButton = By.xpath("(//div[@class='cartflag']/span)[2]");
	private By itemAddPlusQLButton = By.cssSelector("li.qty-add.ripple");
	private By itemRemoveQLButton = By.cssSelector("li.qty-remove.ripple");
	private By viewMoreDetailsLink = By.cssSelector("div.viewMoreDeatils");
	private By basketIcon = By.id("addedto-cart");
	private By itemTitle = By.xpath("(//div[@class='product-name'])[1]");
	private By itemPrice = By.xpath("(//div[@class='member-prices'])[1]");
	private By itemQuantity = By.xpath("(//li[@class='qty-count'])[1]");
	private By itemSize = By.xpath("(//div[@class='size remove-arrow'])[1]");

	// private By itemAddQButton=By.cssSelector("span.addbtn-new.ripple");
	// private By itemAddPlusQButton = By.cssSelector("li.qty-add.ripple");

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		itemObj = new Item();
	}

	public boolean isSearchPageURLPresent() {
		return elementUtil.waitForUrlToBe(Constants.SEARCH_PAGE_URL, 10);
	}

	public String getSearchTermFromBreadCrumb() {
		elementUtil.waitForElementPresent(searchBreadCrumbContainer, 10);
		return elementUtil.doGetText(searchTermInBreadCrumb);
	}

	public boolean addItems(int itemCount) {
		if (elementUtil.getElements(itemLink).size() > 0) {
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
			//itemObj.setItemName(elementUtil.doGetText(itemTitle));
			//itemObj.setItemQuantity(elementUtil.doGetText(itemQuantity));
			//itemObj.setItemPrice(elementUtil.doGetText(itemPrice));
			//itemObj.setItemSize(elementUtil.doGetText(itemSize));
			
			return true;
		}
		return false;
	}

	public boolean addItems1(int itemCount) {
		if (elementUtil.getElements(itemLink).size() > 0) {
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

	public QuickbuyPage clickItem() {
		// elementUtil.waitForElementVisible(itemLink, 10);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementUtil.doClick(itemLink);
		return new QuickbuyPage(driver);
	}

	public boolean isQuickViewPresent() {
		elementUtil.waitForElementVisible(quickViewOverlay, 10);
		if (elementUtil.doIsDisplayed(quickViewOverlay))
			return true;
		return false;
	}

	public BasketPage navigateToBasketPage() {
		elementUtil.clickWhenReady(basketIcon, 10);
		return new BasketPage(driver);
	}
}
