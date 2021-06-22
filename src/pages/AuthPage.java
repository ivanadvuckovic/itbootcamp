package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}
	
	public WebElement getAccountNameButton() {
		return this.driver.findElement(By.className("accounts-link"));
	}
	
	public WebElement getMyAccountLink() {
		return this.driver.findElement(By.linkText("My Account"));
	}
	
	public WebElement getLogoutButton() {
		return this.driver.findElement(By.linkText("Logout"));
	}
	
	public void logout() {
		this.getAccountNameButton().click();
		this.getLogoutButton().click();
	}
 
}
