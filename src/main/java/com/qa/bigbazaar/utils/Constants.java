package com.qa.bigbazaar.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	//public static final String HOME_PAGE_TITLE = "Big Bazaar - Get Home Care & Food Items at Best Price";
	public static final String HOME_PAGE_TITLE = "Big Bazaar - Get Home Care & Food Items at Best Prices";
	//public static final String HOME_PAGE_URL="https://preprod-web.bigb.fgcommerce.net/";
	public static final String HOME_PAGE_URL="https://shop.bigbazaar.com/";
	
	
	//public static final String SEARCH_PAGE_TITLE = "Big Bazaar - Get Home Care & Food Items at Best Prices";
	public static final String SEARCH_PAGE_TITLE = "Order online | Grocery, fruits & vegetables store | Home delivery in India";
	//public static final String SEARCH_PAGE_URL = "https://preprod-web.bigb.fgcommerce.net/search/Apples";
	public static final String SEARCH_PAGE_URL = "https://shop.bigbazaar.com/search/jeans";
	
	//public static final String SEARCH_TERM="Methi";
	public static final String SEARCH_TERM="jeans";
	
	public static final int INITIAL_ITEM_COUNT=0;
	public static final int ITEM_COUNT=1;
	
	public static List<String> accSecList;
	
	//public static final String PRODUCT_PAGE_URL="https://preprod-web.bigb.fgcommerce.net/productDetails/Apple-Kashmir/LO799VE16GITINFUR/5538";
	public static final String PRODUCT_PAGE_URL="https://shop.bigbazaar.com/productDetails/Solid-Jeans/DJ875BO17ZLUINFUR/4731";
	public static final String BASKET_PAGE_TITLE="My Basket";
	
	//public static final String PREVIOUS_PURCHASE_URL="https://preprod-web.bigb.fgcommerce.net/catalog/previously-bought";
	public static final String PREVIOUS_PURCHASE_URL="https://shop.bigbazaar.com/catalog/previously-bought";
	public static final String EMPTY_BASKET_TEXT="You are still carrying an empty basket";
	//public static final String EMPTY_BASKET_IMAGE_PATH="https://content-preprod.bigbazaarstore.com/assets/common/images/cart/empty-cart.svg";
	public static final String EMPTY_BASKET_IMAGE_PATH="https://cflare.shop.bigbazaar.com/assets/common/images/cart/empty-cart.svg";
	
	
	public static List<String> getExpectedAccountsSectionList() {
		accSecList = new ArrayList<String>();
		accSecList.add("My Account");
		accSecList.add("My Orders");
		accSecList.add("My Affiliate Account");
		accSecList.add("Newsletter");
		return accSecList;
	}
	
	public static List<String> checkoutSecList;
	
	public static List<String> getExpectedCheckoutSectionList() {
		checkoutSecList = new ArrayList<String>();
		checkoutSecList.add("Login");
		checkoutSecList.add("Select Address");
		checkoutSecList.add("Select Slot");
	
		return accSecList;
	}
}
