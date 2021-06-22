package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MealItemTest extends BasicTest{
	
	@Test
	public void addMeal() throws InterruptedException {
		driver.get(this.baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		lcp.closePopup();
		mealPage.getAddtoCart("2");
		WebElement msg = this.driver.findElement(By.xpath("//*[contains(@class, 'system_message')]"));
		waiter.until(ExpectedConditions.attributeToBe(msg, "style", "display: block;"));
		Assert.assertTrue(nsp.getAlertText().contains("Please Select Location"), "Message Please Select Location not disaplyed");
		nsp.waitMsgToDissapear();
		lcp.setLocation("City Center - Albany");
		Thread.sleep(2000);
		mealPage.getAddtoCart("2");
		Thread.sleep(2000);
		Assert.assertTrue(nsp.getAlertText().contains("Meal Added To Cart"), "Meal Added To Cart message not disaplyed");
	}
	
	@Test
	public void addMealToFavourite() throws InterruptedException {
		driver.get(this.baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		lcp.closePopup();
		mealPage.addToFavourite();
		Assert.assertTrue(nsp.getAlertText().contains("Please login first!"), "Please login first! message not disaplyed");
		loginPage.login(this.userName, this.password);
		driver.navigate().to(this.baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		mealPage.addToFavourite();
		Assert.assertTrue(nsp.getAlertText().contains("Product has been added to your favorites."), "Product has been added to your favorites. message not disaplyed");
	}

}
