package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}

	public WebElement getLocation() {
		return this.driver.findElement(By.linkText("Select Location"));
	}
	
	public WebElement getCloseLocation() {
//		WebElement locationDiv = this.driver.findElement(By.id("location-popup"));
		boolean exists = this.existsElement(By.className("location-search"));
		WebElement close = this.driver.findElement(By.className("close-btn"));
		return close;
	}
	
	public void closePopup() {
		js.executeScript("arguments[0].click()", this.getCloseLocation());
	}
	
	public String getKeyword() {
		return this.driver.findElement(By.id("locality_keyword")).getText();
	}
	
	public WebElement getLocationItem(String locationName) {
		return this.driver.findElement(By.id(locationName));
	}
	
	public WebElement getLocationInput() {
		return this.driver.findElement(By.id("location_id"));
	}
	
	public WebElement getSubmit() {
		return this.driver.findElement(By.tagName("btn_submit"));
	}
	
	public void setLocation(String locationName) {
		this.getLocation().click();
		String inuptValue = this.getKeyword();
		this.getLocationInput();
		js.executeScript("arguments[0].value=arguments[1]", this.getLocationInput(), inuptValue);
		js.executeScript("arguments[0].click();", this.getSubmit());
		this.getCloseLocation().click();
	}
	
	private boolean existsElement(By by) {
	    try {
	        driver.findElement(by);
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	}

}
