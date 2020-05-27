package flipkartTestCases;

import org.testng.annotations.Test;

import kdd.keyword;



public class testCases {

	@Test
	public void verifyPriceRange() throws InterruptedException
	{
		keyword.openBrowser("Chrome");
	 keyword.launchUrl("https://www.flipkart.com");
	 Thread.sleep(4000);
	 keyword.closeLoginPopup();
	 keyword.searchProduct("shoes");
	}

}
