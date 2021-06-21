package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage extends BasicPage{

	public ProfilePage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}
	
	public void getUploadImageButton() {
		WebElement button = this.driver.findElement(By.xpath("//a[@title=\"Upload\"]"));
		js.executeScript("arguments[0].click();", button);
	}
	
	public void sendImage() {
		this.driver.findElement(By.xpath("//input[@type='file']")).sendKeys("img/avatar.png");

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
	
	public void changeBasicInfo(String firstName, String lastName, String email, String address, String phoneNumber, String zipCode, String country, String state, String city) {
		this.getFirstname().sendKeys(firstName);
		this.getLastname().sendKeys(lastName);
		this.getEmail().sendKeys(email);
		this.getAddress().sendKeys(address);
		this.getPhone().sendKeys(phoneNumber);
		this.getZipCode().sendKeys(zipCode);
		this.getCountry().sendKeys(country);
		this.getState().sendKeys(state);
		this.getCity().sendKeys(city);
	}

}
