package DemoHW2;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class WinDow extends Hooks{
	
	
	public static void main(String[] args) throws InterruptedException {
		
		setUp("safari");
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement searchField = driver.findElement(By.cssSelector("#Wikipedia1_wikipedia-search-input"));
		WebElement searchButton = driver.findElement(By.cssSelector(".wikipedia-search-button"));
		
		//STEP 1. Nike, Inc.
		searchField.sendKeys("Nike, Inc.");
		searchButton.click();
		Thread.sleep(1000);
		
		WebElement nikeLink = driver.findElement(By.linkText("Nike, Inc."));
	
		nikeLink.click();
		
		//STEP 2. Puma (brand)
		
		searchField.clear();
		searchField.sendKeys("Puma (brand)");
		searchButton.click();
		Thread.sleep(1000);
		
		WebElement pumaLink = driver.findElement(By.linkText("Puma (brand)"));
		pumaLink.click();
		
		//Step 3: Adidas
		searchField.clear();
		searchField.sendKeys("Adidas");
		searchButton.click();
		Thread.sleep(1000);
		
		WebElement adidasLink = driver.findElement(By.linkText("Adidas"));
		adidasLink.click();
		
		//This will get the current active window ID and we will make this as parent window
		String parentWindow = driver.getWindowHandle();
		
		System.out.println("Parent Window ID: " + parentWindow);
		
		
		/**
		 * Once we capture the parent windowID and we are done opening new window/tab
		 *
		 *	Now we need to retrieve all the WINDOW IDS --> getWindowHandles()
		 *
		 *	getWindowHandles() will return all the ids ( parent + child)
		 */
		
		Set<String> allWindows = driver.getWindowHandles();
		
		System.out.println("All Window IDS: " + allWindows);
		
		
		
		
		for(String windowID: allWindows) {
			//This will switch to window/tab that belongs the ID
			driver.switchTo().window(windowID);
			
			//We cannot tell which window it will switch because id is dynamic and randomly generated
			
			//Once we retrieve to the window we need to retrieve the PAGE TITLE
			
			String pageTitle = driver.getTitle();
			
			System.out.println(pageTitle + ": WINDOW ID: "+ windowID);
			
			
			
			if(pageTitle.equals("Nike, Inc. - Wikipedia")) {
				
				//TODO code..
				
				System.out.println("*****NIKE************");		
				WebElement nikeHomePage = driver.findElement(By.xpath("//a[@href='http://nike.com']"));		
				nikeHomePage.click();
				
				String nikePageTitle = driver.getTitle();
				
				System.out.println(nikePageTitle);
				
				//close the tab
				driver.close();
				
				
			} else if(pageTitle.equals("Puma (brand) - Wikipedia")) {
				
				System.out.println("*****PUMA************");
				
				WebElement pumaHomePage = driver.findElement(By.xpath("//a[@href='https://eu.puma.com/']"));		
				pumaHomePage.click();
				
				String pumaPageTitle = driver.getTitle();
				
				System.out.println(pumaPageTitle);
				
				//close the tab
				driver.close();
				
				
			} else if (pageTitle.equals("Adidas - Wikipedia")) {
				
				System.out.println("*****Adidas************");
				
				WebElement adidasHomePage = driver.findElement(By.xpath("//a[@href='https://www.adidas.com/']"));	
				adidasHomePage.click();
				
				String adidasPageTitle = driver.getTitle();
				
				System.out.println(adidasPageTitle);
				
				//close the tab
				driver.close();
			}	
		}
		
		/**
		 * TODO
		 */
		
		
		// ENter John in Name Field..
		
		driver.switchTo().window(parentWindow);
		WebElement nameField = driver.findElement(By.id("name"));
		nameField.sendKeys("John");
		
		Thread.sleep(2000);
		tearDown();
	}




}
