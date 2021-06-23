package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
		lcp.getLocation().click();
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
	
	@Test
	public void clearCartTest() throws InterruptedException, IOException {
		File file = new File("data/Data.xlsx");
		FileInputStream fs = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheet("Meals");
		
		SoftAssert sa = new SoftAssert();
		
		driver.get(this.baseUrl + "meals");
		lcp.setLocation("City Center - Albany");
		Thread.sleep(3000);
		 for (int i = 1; i <= 5; i++) {
			String mealUrl = sheet.getRow(i).getCell(0).getStringCellValue();
			Integer qauntity = (int) sheet.getRow(i).getCell(1).getNumericCellValue();
			driver.get(mealUrl);
			Thread.sleep(3000);
			mealPage.getAddtoCart(qauntity.toString());
			Thread.sleep(2000);
			sa.assertTrue(nsp.getAlertText().contains("Meal Added To Cart"), "Meal Added To Cart message not displayed!");
			nsp.waitMsgToDissapear();
		}
		 csp.removeAllFromCart();
		 sa.assertTrue(nsp.getAlertText().contains("All meals removed from Cart successfully"), "All meals removed from Cart successfully message not displayed");
	}

}
