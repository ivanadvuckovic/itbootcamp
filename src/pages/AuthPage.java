package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}
	
	public WebElement getAccountNameButton() {
		return this.driver.findElement(By.xpath("//div[@class=\"accounts-link\"]/ul/li/a"));
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
