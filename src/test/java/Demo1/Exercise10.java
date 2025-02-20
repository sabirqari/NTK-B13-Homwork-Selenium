package Demo1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class Exercise10 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp("safari");

		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement searchField = driver.findElement(By.cssSelector("#Wikipedia1_wikipedia-search-input"));
		WebElement searchButton = driver.findElement(By.cssSelector(".wikipedia-search-button"));
		// S 1 Ebay selenium
		searchField.sendKeys("Selenium (software)");
		searchButton.click();
		Thread.sleep(3000);

		WebElement Selenium = driver.findElement(By.linkText("Selenium (software)"));
		Selenium.click();
		// S 2 Ebay
		searchField.clear();
		searchField.sendKeys("Ebay");
		searchButton.click();
		Thread.sleep(3000);

		WebElement Ebay = driver.findElement(By.linkText("Ebay"));
		Ebay.click();

		// S 3 Target Corporation
		searchField.clear();
		searchField.sendKeys("Target Corporation");
		searchButton.click();
		Thread.sleep(3000);

		WebElement TargetCorporation = driver.findElement(By.linkText("Target Corporation"));
		TargetCorporation.click();

		// S 3 Google

		searchField.clear();
		searchField.sendKeys("Google");
		searchButton.click();
		Thread.sleep(3000);

		WebElement Google = driver.findElement(By.linkText("Google"));
		Google.click();

		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window ID: " + parentWindow);

		Set<String> allWindows = driver.getWindowHandles();

		for (String windowID : allWindows) {
			driver.switchTo().window(windowID);

			String pageTitle = driver.getTitle();
			System.out.println(pageTitle + " : WINDOW ID" + windowID);

			System.out.println("***************SELENIUM*****************");
			if (pageTitle.equals("Selenium (software) - Wikipedia")) {
				WebElement SeleniumHomePage = driver.findElement(By.xpath("//a[@href=\"https://selenium.dev/\"]"));
				SeleniumHomePage.click();
				String SeleniumPageTitle = driver.getTitle();
				System.out.println("SeleniumPageTitle");

			} else if (pageTitle.equals("True")) {

				System.out.println("Wooow once I am done here I will read all the available documents.");

			} else {
				System.out.println("I am still going to read all the available documents.");

				driver.close();
			}
			driver.switchTo().window(parentWindow);
			if (pageTitle.equals("eBay - Wikipedia")) {
				System.out.println("***************Ebay*****************");
				WebElement EbayHomePage = driver.findElement(By.xpath("//a[@href=\"https://www.ebay.com/\"]"));
				EbayHomePage.click();
				String EbayPageTitle = driver.getTitle();
				System.out.println(EbayPageTitle);

				WebElement Category = driver.findElement(By.id("gh-cat"));
				Category.sendKeys("times");
			} else if (pageTitle.equals("true")) {
				System.out.println("TESTCASE PASSED");
			} else {
				System.out.println("TESTCASE FAILED");
				driver.close();
			}
			driver.switchTo().window(parentWindow);
			if (pageTitle.equals("Target Corporation - Wikipedia")) {

				System.out.println("***************Target*****************");
				WebElement TargetHomePage = driver
						.findElement(By.xpath("//a[@href=\"https://corporate.target.com/\"]"));
				TargetHomePage.click();
				String TargetPageTitle = driver.getTitle();
				System.out.println(TargetPageTitle);

			} else if (pageTitle.equals("true")) {
				System.out.println("TESTCASE PASSED");
			} else {
				System.out.println("TESTCASE FAILED");
				driver.close();
			}
			System.out.println("***************Google*****************");
			driver.switchTo().window(parentWindow);
			if (pageTitle.equals("Google - Wikipedia")) {

				WebElement GoogleHomePage = driver.findElement(By.xpath("/a[@href=\"https://about.google/\"]"));
				GoogleHomePage.click();
				String GooglePageTitle = driver.getTitle();
				System.out.println(GooglePageTitle);
				driver.close();
			}
		}
		tearDown();
	}

}
