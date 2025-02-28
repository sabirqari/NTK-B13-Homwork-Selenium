package DemoHW2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.Hooks;

public class DemoActions extends Hooks {
	
	
	public static void main(String[] args) throws InterruptedException {
		setUp("safari");
		
	
		executeAllActions();
		
		tearDown();
		
	}
		public static void executeAllActions() throws InterruptedException {
			dragAction();          // Calls the drag-and-drop action
			moveAction();          // Calls the move-to-action
			dynamicClickAction();  // Calls the dynamic click action
			rightClickAction();    // Calls the right-click action
			doubleClickAction();   // Calls the double-click action
		

	}
	
	public static void dragAction() throws InterruptedException {
		driver.get("https://jqueryui.com/droppable/#photo-manager");
		driver.switchTo().frame(0);
		
		WebElement pic1 = driver.findElement(By.xpath("//ul[@id='gallery']//li[1]"));
		WebElement pic2 = driver.findElement(By.xpath("//ul[@id='gallery']//li[2]"));
		WebElement pic3 = driver.findElement(By.xpath("//ul[@id='gallery']//li[3]"));
		WebElement pic4 = driver.findElement(By.xpath("//ul[@id='gallery']//li[4]"));
		
		
		WebElement trash = driver.findElement(By.xpath("//*[@id='trash']"));
		Actions actionsObj = new Actions(driver);

		actionsObj.dragAndDrop(pic1, trash).build().perform();
		Thread.sleep(500);
		actionsObj.dragAndDrop(pic2, trash).build().perform();
		Thread.sleep(500);

		actionsObj.dragAndDrop(pic3, trash).build().perform();
		Thread.sleep(500);

		actionsObj.dragAndDrop(pic4, trash).build().perform();
		
	}
	
	
	
	public static void moveAction() {
		driver.get("https://demo.automationtesting.in/Register.html");
		
		WebElement interactions = driver.findElement(By.xpath("//a[text()='Interactions ']"));
		WebElement dragDrop = driver.findElement(By.xpath("//a[text()='Drag and Drop ']"));
		WebElement staticEl = driver.findElement(By.xpath("//a[text()='Static ']"));
		
		Actions actionsObj = new Actions(driver);

		
		actionsObj.moveToElement(interactions).moveToElement(dragDrop).moveToElement(staticEl).click().build().perform();
		
		
		
	}
	
	
	
	
	
	public static void dynamicClickAction() {
		
		driver.get("https://demoqa.com/buttons");
		
		WebElement btn = driver.findElement(By.xpath("//button[text()='Click Me']"));
		
		
		Actions actionsObj = new Actions(driver);
		
		//this will perform right click
		actionsObj.click(btn).build().perform();
		
		WebElement message = driver.findElement(By.id("dynamicClickMessage"));		
		String text = message.getText();
		
		System.out.println(text);

	}

	public static void rightClickAction() {		
		driver.get("https://demoqa.com/buttons");	
		WebElement btn = driver.findElement(By.id("rightClickBtn"));
			
		Actions actionsObj = new Actions(driver);
		
		//this will perform right click
		actionsObj.contextClick(btn).build().perform();
		
		WebElement message = driver.findElement(By.id("rightClickMessage"));		
		String text = message.getText();
		System.out.println(text);
	}
	
	
	public static void doubleClickAction() {		
		driver.get("https://demoqa.com/buttons");		
		WebElement btn = driver.findElement(By.id("doubleClickBtn"));

		Actions actionsObj = new Actions(driver);		
		//this will perform double click
		actionsObj.doubleClick(btn).build().perform();
		
		WebElement message = driver.findElement(By.id("doubleClickMessage"));		
		String text = message.getText();
		
		System.out.println(text);
	}
	
	
	
	
	
	

}

