package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}

	public WebElement getLocation() {
		return this.driver.findElement(By.xpath("//div[@class=\"location-selector\"]/a"));
	}
	
	public WebElement getCloseLocation() {
//		WebElement locationDiv = this.driver.findElement(By.id("location-popup"));
		boolean exists = this.existsElement(By.className("location-search"));
		WebElement close = this.driver.findElement(By.xpath("//a[@class=\"close-btn close-btn-white\"]"));
		return close;
	}
	
	public void closePopup() {
		js.executeScript("arguments[0].click()", this.getCloseLocation());
	}
	
	public WebElement getKeyword() {
		return this.driver.findElement(By.id("locality_keyword"));
	}
	
	public WebElement getLocationItem(String locationName) {
		WebElement li = this.waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li/a[contains(text(), \"" + locationName + "\")]/.."))); 
		return li;
	}
	
	public WebElement getLocationInput() {
		WebElement locationInput = this.waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"location_id\"]"))); 
		return locationInput;
	}
	
	public WebElement getSubmit() {
		return this.driver.findElement(By.xpath("//*[@name=\"btn_submit\"]"));
	}
	
	public void setLocation(String locationName) throws InterruptedException {
		this.getKeyword().click();
		WebElement li = this.getLocationItem(locationName);
		int value = Integer.parseInt(li.getAttribute("data-value"));
		WebElement locationInput = this.getLocationInput();
		js.executeScript("arguments[0].value=arguments[1];", locationInput, value);
		Thread.sleep(3000);
		this.getSubmit().submit();
//		this.getCloseLocation().click();
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
