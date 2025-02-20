package DemoHW2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class HandlingAlert extends Hooks {

	public static void main(String args[]) throws InterruptedException {

		setUp("safari");

		// Navigate

		driver.get("https://demo.automationtesting.in/Alerts.html");
		//Thread.sleep(1000);
		
	

		
		
		WebElement alert_text_button= driver.findElement(By.xpath("//a[@href='#Textbox']"));
		alert_text_button.click();
		Thread.sleep(300);
		
		WebElement promt_box= driver.findElement(By.xpath("//button[@class=\"btn btn-info\"]"));
		promt_box.click();
       Thread.sleep(300);
		
       
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Sabirrr");
		alert.accept();
		 Thread.sleep(300);
		
		WebElement messag = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[3]/button"));
		messag.sendKeys("How are you today");
		alert.accept();
		 
		Alert messagAlert = driver.switchTo().alert();
		
		
		WebElement alertbutton= driver.findElement(By.xpath("//a[@href='#Textbox']"));
		 alertbutton.click();
		 Alert alert1 = driver.switchTo().alert();
			alert1.sendKeys("Sabirrr");
			alert1.accept();
		


		
		
		
		
		tearDown();
	}

}