package com.qa.bigbazaar.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.bigbazaar.factory.DriverFactory;
import com.qa.bigbazaar.pages.AxisSimulatorOrdersPage;
import com.qa.bigbazaar.pages.AxisSimulatorTopupPage;
import com.qa.bigbazaar.pages.BasketPage;
import com.qa.bigbazaar.pages.CheckoutPage;
import com.qa.bigbazaar.pages.EmptyBasketPage;
import com.qa.bigbazaar.pages.FuturepayPage;
import com.qa.bigbazaar.pages.FuturepayTopupPage;
import com.qa.bigbazaar.pages.HomePage;
import com.qa.bigbazaar.pages.MyProfilePage;
import com.qa.bigbazaar.pages.OrderSuccessPage;
import com.qa.bigbazaar.pages.ProductInfoPage;
import com.qa.bigbazaar.pages.QuickbuyPage;
import com.qa.bigbazaar.pages.SearchPage;

public class BaseTest {

	WebDriver driver;
	DriverFactory df;
	public Properties prop;
	public HomePage homePage;
	public SearchPage searchPage;
	public QuickbuyPage quickbuyPage;
	public ProductInfoPage productInfoPage;
	public EmptyBasketPage emptybasketPage;
	public BasketPage basketPage;
	public CheckoutPage checkoutPage;
	public OrderSuccessPage orderSuccessPage;
	public AxisSimulatorOrdersPage axisPage;
	public AxisSimulatorTopupPage axisTopupPage;
	public MyProfilePage myProfilePage;
	public FuturepayPage futurepayPage;
	public FuturepayTopupPage futurepayTopupPage;

	// setUp() to launch the browser
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		driver.get(prop.getProperty("appUrl"));
		homePage = new HomePage(driver);
		searchPage = new SearchPage(driver);
		quickbuyPage = new QuickbuyPage(driver);
		productInfoPage = new ProductInfoPage(driver);
		basketPage = new BasketPage(driver);
		checkoutPage = new CheckoutPage(driver);
		orderSuccessPage = new OrderSuccessPage(driver);
		axisPage = new AxisSimulatorOrdersPage(driver);
		axisTopupPage=new AxisSimulatorTopupPage(driver);
		myProfilePage = new MyProfilePage(driver);
		futurepayPage = new FuturepayPage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
