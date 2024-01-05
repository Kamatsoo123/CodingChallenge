package WebTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceDemo {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\Selenium\\chromedriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Scenario 1 Login and navigate homepage
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		 if (driver.findElements(By.id("inventory_container")).size() != 0) {
	            System.out.println("Login successful!");
	           
	        } else {
	            System.out.println("Login failed!");
	        }
		
		
		//Scenario 1 logout and navigate loginpage
	     WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
	        menuButton.click();

	     // Explicit wait for the logout link to be clickable with a timeout of 10 seconds
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 10 seconds timeout
	        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
	        logoutLink.click();
	        
	        // Verify user is navigated to login page after logout
	        WebElement loginForm = driver.findElement(By.id("login-button"));
	        if (loginForm.isDisplayed()) {
	            System.out.println("Logout successful.");
	        } else {
	            System.out.println("Logout failed");
	        }
	        
	     //Scenario 2 log in using locked out user
	        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();
			
			 WebElement errorMessage = driver.findElement(By.className("error-button"));
		        if (errorMessage.isDisplayed()) {
		            System.out.println("Login Failed.");
		        } else {
		            System.out.println("Logout Success");
		        }
	        // Close the browser
	        //driver.quit();
		
	}

}
