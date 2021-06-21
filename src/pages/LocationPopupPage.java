package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
		js = (JavascriptExecutor) driver;
	}

	public WebElement getLocation() {
		return this.driver.findElement(By.linkText("Select Location"));
	}
	
	public WebElement getCloseLocation() {
		WebElement locationDiv = this.driver.findElement(By.id("location-popup"));
		WebElement close = locationDiv.findElement(By.className("close-btn-white"));
		return close;
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

}
