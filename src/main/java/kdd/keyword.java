package kdd;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import flipkart.customutil.propertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;




public class keyword {
	private static WebDriver driver;
	private static Logger log = Logger.getLogger(keyword.class);
	static String url = "";

	public static void openBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;

		default:
			break;
		}

	}

	public static void launchUrl(String url) {

		driver.get(url);
		driver.manage().window().maximize();

	}

	private static WebElement getWebElement(String locator) {
		System.out.println("Spliting the locator" + locator);
		String locatorType = propertyFile.getLocator(locator)[0];
		String locatorValue = propertyFile.getLocator(locator)[1];
		System.out.println("LocatorType:" + locatorType);
		System.out.println("LocatorValue:" + locatorValue);

		WebElement element = null;

		switch (locatorType) {
		case "xpath":
			element = driver.findElement(By.xpath(locatorValue));
			break;

		case "css":
			element = driver.findElement(By.cssSelector(locatorValue));
			break;

		case "id":
			element = driver.findElement(By.id(locatorValue));
			break;

		case "class":
			element = driver.findElement(By.className(locatorValue));
			break;

		case "linktext":
			element = driver.findElement(By.linkText(locatorValue));
			break;

		case "partialLinkText":
			element = driver.findElement(By.partialLinkText(locatorValue));
			break;

		default:
			break;
		}

		return element;

	}

	public static void searchProduct(String productName) throws InterruptedException
	{
		getWebElement("searchComponent").sendKeys(productName);
		log.info("To search a component");
		Thread.sleep(2000);
		getWebElement("magnifier").click();
		log.info("click on magnifier");
		Thread.sleep(2000);
		
	}
	public static void closeLoginPopup()
	{
		getWebElement("popupCloseButton").click();
		log.info("To close popup");
		
	}
	}


