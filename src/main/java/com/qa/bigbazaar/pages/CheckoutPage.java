package com.qa.bigbazaar.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.bigbazaar.utils.ElementUtil;
import com.qa.bigbazaar.utils.JavaScriptUtil;

public class CheckoutPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	private JavaScriptUtil javaScriptUtil;
	String s;

	By checkoutSectionText = By.xpath("//span[@class='num num_select']/h5");
	By mobileVerifiedText = By.xpath("(//div[@class='panel-title']//h3)[1]");
	By mobileNumberText = By.xpath("//div[@class='panel-title']//p[@class='Mobile_num']");

	By addressTagText = By.xpath("//div[@class='header_content_inside']/h5");
	By addressText = By.xpath("//div[@class='header_content_inside']//div");

	By activeDeliveryDayText = By.xpath("//li[@class='activein']");
	By selectedDeliverySlotText = By.xpath("//h5[@class='timeSlot']");

	By defaultDeliverySlot = By.xpath("(//div[@class='time_slot_radio']//input)[1]");
	By deliveryText = By.xpath("//p[@class='pickUp-text m_top10']");
	By proceedToPaymentButton = By.xpath("//button[@id='express_next_button']");
	By checkoutHeaderText = By.cssSelector("span.pull-left.text_right");
	By loginText = By.cssSelector("div.panel.panel-default.AccordionItemBlock.logout-block h5");
	By deliverySlots = By.xpath("//div[@class='time_slot_radio']//span");
	By selectPaymentTypeText = By.xpath("//div[@class='header_content']//div[@class='select_text']");
	By ele = By.xpath("//div[@class='listing-slider']//img");
	By fpActivePayment = By.cssSelector("div.cardStyle2.activePayment");
	By fpPayNowButton = By.cssSelector("button.futurepaidBtn");
	By ccPayment = By.id("CreditCard");
	By ccActivePayment = By.xpath("//div[@class='cardStyle2 activePayment' and @id='CreditCard']");

	By dcPayment = By.id("DebitCard");
	By dcActivePayment = By.xpath("//div[@class='cardStyle2 activePayment' and @id='DebitCard']");
	By codPayment = By.id("CashOnDelivery");
	By codActivePayment = By.xpath("//div[@class='cardStyle2 lastBorderBtm activePayment' and @id='CashOnDelivery']");
	By codPayButton = By.xpath("//div[@class='codPayBtn']/button");

	By cvvText = By.cssSelector("input[id^='savedcvv']");
	By scPayButton = By.cssSelector("Button.below.paybelowbuttonenable.payBtnActive");
	By ccNumberText = By.id("cardnumber");
	By ccDateText = By.id("cardDate");
	By ccCvvText = By.id("cvv");
	By ccNameText = By.id("cname");

	By dcNumberText = By.id("cardnumberdebit");
	By dcDateText = By.id("cardDatedebit");
	By dcCvvText = By.id("cvvdebit");
	By dcNameText = By.id("cnamedebit");
	By dcPayButton = By.id("payBtndebit");

	By payButton = By.xpath("//button[@id='payBtn' and @class='text-center belowBtnBox payBtnActive']");

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}

	public List<String> getCheckoutSectionText() {
		List<WebElement> checkoutSectionList = elementUtil.getElements(checkoutSectionText);
		List<String> checkoutSectionTextList = new ArrayList<String>();
		for (WebElement element : checkoutSectionList) {
			checkoutSectionTextList.add(element.getText().trim());
		}

		return checkoutSectionTextList;
	}

	public String getMobileVerifiedText() {
		elementUtil.waitForElementPresent(mobileVerifiedText, 10);
		if (elementUtil.doIsDisplayed(mobileVerifiedText)) {
			return elementUtil.doGetText(mobileVerifiedText);
		}

		return null;
	}

	public String getMobileNumber() {
		elementUtil.waitForElementPresent(mobileNumberText, 10);
		if (elementUtil.doIsDisplayed(mobileNumberText)) {
			return elementUtil.doGetText(mobileNumberText);
		}
		return null;
	}

	public String getAddressTag() {
		elementUtil.waitForElementPresent(addressTagText, 10);
		if (elementUtil.doIsDisplayed(addressTagText)) {
			return elementUtil.doGetText(addressTagText);
		}
		return null;
	}

	public String getAddress() {
		elementUtil.waitForElementPresent(addressText, 10);
		if (elementUtil.doIsDisplayed(addressText)) {
			return elementUtil.doGetText(addressText);
		}
		return null;
	}

	public String getActiveDeliveryDay() {
		elementUtil.waitForElementPresent(activeDeliveryDayText, 10);
		if (elementUtil.doIsDisplayed(activeDeliveryDayText)) {
			return elementUtil.doGetText(activeDeliveryDayText);
		}
		return null;

	}

	public String getSelectedDeliverySlot() {
		elementUtil.waitForElementPresent(selectedDeliverySlotText, 10);
		if (elementUtil.doIsDisplayed(selectedDeliverySlotText)) {
			return elementUtil.doGetText(selectedDeliverySlotText);
		}
		return null;
	}

	public String getCheckoutHeaderText() {
		elementUtil.waitForElementVisible(checkoutHeaderText, 10);
		return elementUtil.doGetText(checkoutHeaderText);
	}

	public boolean checkItemImageInDeliverySlot() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elementUtil.doIsDisplayed(ele);
	}

	public void selectDeliverySlot(String deliverySlot) {

		// div[@class='time_slot_radio']//span[text()='7:00 PM to 10:00
		// PM']/preceding-sibling::*
		By deliverySlotElement = By
				.xpath("//div[@class='time_slot_radio']//span[text()='" + deliverySlot + "']/preceding-sibling::input");
		elementUtil.waitForElementPresent(deliverySlotElement, 20);

		/*
		 * if (!elementUtil.doGetAttribute(deliverySlotElement,
		 * "checked").equalsIgnoreCase("true")) {
		 * elementUtil.clickWhenReady(deliverySlotElement, 15); }
		 */

		if (!elementUtil.doIsChecked(deliverySlotElement)) {
			elementUtil.doClick(deliverySlotElement);
		}

		elementUtil.clickWhenReady(proceedToPaymentButton, 10);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public OrderSuccessPage makeFPOrder() {
		elementUtil.waitForElementVisible(fpActivePayment, 10);
		if (elementUtil.doIsDisplayed(fpActivePayment)) {
			elementUtil.clickWhenReady(fpPayNowButton, 10);
		} else {
			elementUtil.clickWhenReady(fpActivePayment, 10);
			elementUtil.clickWhenReady(fpPayNowButton, 10);
		}
		return new OrderSuccessPage(driver);
	}

	public AxisSimulatorOrdersPage makePayuOrder(String modeOfPayment, String cardType, String cardNum, String cardExpiry,
			String cvv, String cardName) {
		elementUtil.waitForElementVisible(fpActivePayment, 10);
		if (modeOfPayment.equalsIgnoreCase("Credit Card")) {
			elementUtil.clickWhenReady(ccPayment, 10);
			elementUtil.waitForElementVisible(ccActivePayment, 10);

			if (cardType.equalsIgnoreCase("Saved Card")) {
				if (elementUtil.doIsDisplayed(cvvText)) {
					elementUtil.clickWhenReady(cvvText, 10);
					elementUtil.doSendKeys(cvvText, cvv);
					elementUtil.clickWhenReady(scPayButton, 10);
				}
			} else if (cardType.equalsIgnoreCase("New Card")) {
				System.out.println("Card Number:" + cardNum);
				enterCreditCardDetails(cardNum, cardExpiry, cvv, cardName);
			}
		} else if (modeOfPayment.equalsIgnoreCase("Debit Card")) {
			elementUtil.clickWhenReady(dcPayment, 10);
			elementUtil.waitForElementVisible(dcActivePayment, 10);

			if (cardType.equalsIgnoreCase("Saved Card")) {
				if (elementUtil.doIsDisplayed(cvvText)) {
					elementUtil.clickWhenReady(cvvText, 10);
					elementUtil.doSendKeys(cvvText, cvv);
					elementUtil.clickWhenReady(scPayButton, 10);
				}
			} else if (cardType.equalsIgnoreCase("New Card")) {
				System.out.println("Card Number:" + cardNum);
				enterDebitCardDetails(cardNum, cardExpiry, cvv, cardName);
			}
		}
		return new AxisSimulatorOrdersPage(driver);
	}

	private void enterCreditCardDetails(String cardNum, String cardExpiry, String cvv, String cardName) {
		elementUtil.clickWhenReady(ccNumberText, 10);
		javaScriptUtil.sendKeysUsingJSWithId("cardnumber", cardNum);

		elementUtil.clickWhenReady(ccDateText, 10);
		javaScriptUtil.sendKeysUsingJSWithId("cardDate", cardExpiry);

		elementUtil.clickWhenReady(ccCvvText, 10);
		javaScriptUtil.sendKeysUsingJSWithId("cvv", cvv);

		elementUtil.clickWhenReady(ccNameText, 10);
		javaScriptUtil.sendKeysUsingJSWithId("cname", cardName);

		elementUtil.doClick(ccNumberText);
		elementUtil.doSendKeys(ccNumberText, Keys.TAB);

		elementUtil.doClick(ccDateText);
		elementUtil.doSendKeys(ccDateText, Keys.TAB);

		elementUtil.doClick(ccCvvText);
		elementUtil.doSendKeys(ccCvvText, Keys.TAB);

		elementUtil.doClick(ccNameText);
		elementUtil.doSendKeys(ccNumberText, Keys.TAB);

		elementUtil.doClick(ccNumberText);
		elementUtil.doSendKeys(ccNumberText, Keys.ARROW_LEFT);

		elementUtil.clickWhenReady(payButton, 10);
	}

	private void enterDebitCardDetails(String cardNum, String cardExpiry, String cvv, String cardName) {
		elementUtil.clickWhenReady(dcNumberText, 10);
		javaScriptUtil.sendKeysUsingJSWithId("cardnumberdebit", cardNum);

		elementUtil.clickWhenReady(dcDateText, 10);
		javaScriptUtil.sendKeysUsingJSWithId("cardDatedebit", cardExpiry);

		elementUtil.clickWhenReady(dcCvvText, 10);
		javaScriptUtil.sendKeysUsingJSWithId("cvvdebit", cvv);

		elementUtil.clickWhenReady(dcNameText, 10);
		javaScriptUtil.sendKeysUsingJSWithId("cnamedebit", cardName);

		elementUtil.doClick(dcNumberText);
		elementUtil.doSendKeys(dcNumberText, Keys.TAB);

		elementUtil.doClick(dcDateText);
		elementUtil.doSendKeys(dcDateText, Keys.TAB);

		elementUtil.doClick(dcCvvText);
		elementUtil.doSendKeys(dcCvvText, Keys.TAB);

		elementUtil.doClick(dcNameText);
		elementUtil.doSendKeys(dcNumberText, Keys.TAB);

		elementUtil.doClick(dcNumberText);
		elementUtil.doSendKeys(dcNumberText, Keys.ARROW_LEFT);

		// javaScriptUtil.clickElementByJS(elementUtil.getElement(dcPayButton));
		elementUtil.clickWhenReady(dcPayButton, 10);
	}

	public OrderSuccessPage makeCODOrder() {
		elementUtil.waitForElementVisible(fpActivePayment, 10);
		elementUtil.clickWhenReady(codPayment, 10);
		elementUtil.waitForElementVisible(codActivePayment, 10);
		elementUtil.clickWhenReady(codPayButton, 10);
		return new OrderSuccessPage(driver);
	}
}
