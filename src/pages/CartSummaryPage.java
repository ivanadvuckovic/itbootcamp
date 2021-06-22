package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage {

	public CartSummaryPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement getClearAllButton() {
		return this.driver.findElement(By.linkText("Clear All"));
	}
	
	public void removeAllFromCart() {
		this.getClearAllButton().click();
	}
}
