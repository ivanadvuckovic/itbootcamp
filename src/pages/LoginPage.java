package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}
	
	public WebElement getLoginButton() {
		return this.driver.findElement(By.linkText("Login"));
	}
	
	public WebElement getUsername() {
		return this.driver.findElement(By.xpath("//input[@name=\"username\"]"));
	}
	
	public WebElement getPassword() {
		return this.driver.findElement(By.xpath("//input[@name=\"password\"]"));
	}
	
	public WebElement getLoginDialogButton() {
		return this.driver.findElement(By.xpath("//input[@name=\"btn_submit\"]"));
	}
	
	public void login(String username, String password) {
		this.getLoginButton().click();
		this.getUsername().clear();
		this.getPassword().clear();
		this.getUsername().sendKeys(username);
		this.getPassword().sendKeys(password);
		this.getLoginDialogButton().click();
	}
}
