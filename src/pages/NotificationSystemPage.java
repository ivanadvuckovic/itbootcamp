package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class NotificationSystemPage extends BasicPage {

	public NotificationSystemPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}

	public WebElement getAlertMessage() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]" ));
	}
	
	
	public String getAlertText() {
		String alertText = "";
		boolean alertExists = this.elementExist(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
		Assert.assertTrue(alertExists, "Message is not displayed.");
		alertText = this.driver.findElement(By.className("content")).getText();
		boolean alertDanger = this.elementExist(By.xpath("//*[contains(@class, 'alert--danger')"));
		if (alertExists) {
			alertText = this.driver.findElement(By.className("content")).getText();
		}
		return alertText;
	}
	
	public void waitMsgToDissapear() {
		WebDriverWait w = new WebDriverWait(this.driver, 3);
		WebElement msg = this.driver.findElement(By.xpath("//*[contains(@class, 'system_message')]"));
	    w.until(ExpectedConditions.attributeToBe(msg, "style", "display: none;"));
	}
	
	public boolean elementExist(By by) {
		boolean messageExist = true;
		try {
			this.driver.findElement(by);
		} catch(Exception e) {
			messageExist = false;
		}
		return messageExist;
	}
	
	
}
