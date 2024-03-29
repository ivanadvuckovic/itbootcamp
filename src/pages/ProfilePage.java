package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class ProfilePage extends BasicPage {
	Actions actions = new Actions(driver);
	
	public ProfilePage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}
	
	public void getUploadImageButton() throws InterruptedException {
		WebElement avatar = this.driver.findElement(By.className("avatar"));
    	actions.moveToElement(avatar).build().perform();
		WebElement uploadButton = this.driver.findElement(By.xpath("//div[@class=\"hover-elemnts\"]/a"));
		waiter.until(ExpectedConditions.elementToBeClickable(uploadButton));
		js.executeScript("arguments[0].click();", uploadButton);
	}

	public void sendImage(String path) throws IOException {
		String imgPath = new File(path).getCanonicalPath();
		this.driver.findElement(By.xpath("//input[@type='file']")).sendKeys(imgPath);
	}

	public void deleteImage() {
		WebElement button = this.driver.findElement(By.xpath("//a[@title=\"Remove\"]"));
		js.executeScript("arguments[0].click();", button);
	}

	public WebElement getFirstname() {
		return this.driver.findElement(By.xpath("//input[@name=\"user_first_name\"]"));
	}

	public WebElement getLastname() {
		return this.driver.findElement(By.xpath("//input[@name=\"user_last_name\"]"));
	}

	public WebElement getEmail() {
		return this.driver.findElement(By.xpath("//input[@name=\"user_email\"]"));
	}

	public WebElement getAddress() {
		return this.driver.findElement(By.xpath("//input[@name=\"user_address\"]"));
	}

	public WebElement getPhone() {
		return this.driver.findElement(By.xpath("//input[@name=\"user_phone\"]"));
	}

	public Select getCountry() {
		WebElement selectElement = driver.findElement(By.id("user_country_id"));
		Select select = new Select(selectElement);
		return select;
	}

	public Select getState() {
		WebElement selectElement = driver.findElement(By.id("user_state_id"));
		Select select = new Select(selectElement);
		return select;
	}

	public Select getCity() {
		WebElement selectElement = driver.findElement(By.id("user_city"));
		Select select = new Select(selectElement);
		return select;
	}

	public WebElement getZipCode() {
		return this.driver.findElement(By.xpath("//input[@name=\"user_zip\"]"));
	}

	public WebElement getSaveProfileButton() {
		WebElement form = this.driver.findElement(By.name("frmProfileInfo"));
		WebElement saveButton = form.findElement(By.name("btn_submit"));
		return saveButton;
	}

	public WebElement getCurrentPassword() {
		return this.driver.findElement(By.name("current_password"));
	}

	public WebElement getNewPassword() {
		return this.driver.findElement(By.name("new_password"));
	}

	public WebElement getConfirmPassword() {
		return this.driver.findElement(By.name("conf_new_password"));
	}

	public WebElement getSavePasswordButton() {
		WebElement form = this.driver.findElement(By.name("changePwdFrm"));
		WebElement saveButton = form.findElement(By.name("btn_submit"));
		return saveButton;
	}

	public void changeBasicInfo(String firstName, String lastName, String email, String address, String phoneNumber,
			String zipCode, String country, String state, String city) throws InterruptedException {
		this.getFirstname().clear();
		this.getLastname().clear();
		js.executeScript("arguments[0].value = ''", this.getEmail());
		this.getAddress().clear();
		this.getPhone().clear();
		this.getZipCode().clear();
		this.getFirstname().sendKeys(firstName);
		this.getLastname().sendKeys(lastName);
		js.executeScript("arguments[0].value = arguments[1]", this.getEmail(), email);
		this.getAddress().sendKeys(address);
		this.getPhone().sendKeys(phoneNumber);
		this.getZipCode().sendKeys(zipCode);
		this.getCountry().selectByVisibleText(country);
		Thread.sleep(500);
		this.getState().selectByVisibleText(state);
		Thread.sleep(500);
		this.getCity().selectByVisibleText(city);
		this.getSaveProfileButton().click();
	}

}
