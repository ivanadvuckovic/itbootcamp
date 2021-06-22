package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
		// TODO Auto-generated constructor stub
	}
	
	public void selectFirstMeal() {
		 this.driver.findElement(By.className("featured-img")).click();
	}
	
	
	public void getAddtoCart() {
		 this.driver.findElement(By.className("js-proceedtoAddInCart")).click();
	}
	
	public void addToFavourite() {
		 this.driver.findElement(By.xpath("//a[@title=\"Favorite\"]")).click();
	}
	

}
