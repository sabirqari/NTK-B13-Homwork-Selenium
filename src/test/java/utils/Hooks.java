package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	
	public static WebDriver driver;
	
	public static void setUp (String browserName) {
		
		if (browserName.equals("edge")) {
			// set up edge for webdriverManager
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("safari")) {
			// set up safari for webdriverManager
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else if (browserName.equals("firefox")) {
			// set up firefox for webdriverManager
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		//maximize the webpage
				driver.manage().window().maximize();
	}
	// method2 --> closes the browser
		public static void tearDown() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.quit();
		}
	

}