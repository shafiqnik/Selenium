/**
 * Simple automation script
 * It launches the Chrome Browser
 * Goes to BBC.com and searches if there is a News link
 * If there is not a news link then it will goto cnn.com
 * Otherwise it will goto google and search for cbc
 * 
 * Author: Shafiq Ahmad Nek
 * 5/20/2013
 * 
 * 
 */

package AutomationFrameWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {
	
	private static WebDriver driver = null;
	private static WebElement element = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create a new instance of Firefox driver
		//driver = new FirefoxDriver();
		
	    System.setProperty("webdriver.chrome.driver","C:/Work/BrowserDriver/chromedriver.exe");
	    
		//driver = new InternetExplorerDriver();
		driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		loginDetail();
		 
			
	}
	
	
	
	public static void loginDetail(){
		
		driver.get("http://www.bbc.com");
		element = driver.findElement(By.linkText("News"));
		if(element.isDisplayed()){
			System.out.println("found the element News");
			driver.get("http://www.bbc.com/news");
						
		}
		else{
			System.out.print("couldn't find  News");
			driver.get("http://www.cnn.com");
		}
		
				
		    String myword = "cbc";
			driver.get("https://www.google.ca/#q="+myword);
			element.sendKeys(Keys.RETURN);
		}
		
	}
	 
