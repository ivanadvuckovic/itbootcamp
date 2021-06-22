package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement getQuantity() {
		return this.driver.findElement(By.name("product_qty"));
	}
	
	public WebElement getAddCartButton() {
		return this.driver.findElement(By.xpath("//a[@class=\"btn btn--primary btn--large js-proceedtoAddInCart \"]"));
	}	
	
	public void getAddtoCart(String qauntity) {
		this.getQuantity().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		this.getQuantity().sendKeys(qauntity);
		this.getAddCartButton().click();
	}
	
	public void addToFavourite() {
		 this.driver.findElement(By.xpath("//a[@title=\"Favorite\"]")).click();
	}
	

}
