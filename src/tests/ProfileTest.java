package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest{

	@Test
	public void editProfileTest() throws InterruptedException {
		this.driver.get(this.baseUrl + "guest-user/login-form");
		lcp.closePopup();
		loginPage.login(this.userName, this.password);
		Assert.assertTrue(nsp.getAlertText().contains("Login Successfull"), "Login successfull message is not displayed!");
		driver.navigate().to(baseUrl + "member/profile");
		profilePage.changeBasicInfo("John", "Doe", "john@gmailcom", "Oak street", "0712631", "221111", "India", "Assam", "Amguri");
		Assert.assertTrue(nsp.getAlertText().contains("Setup Successful"), "Setup Successfull message is not displayed!");
		nsp.waitMsgToDissapear();
		authPage.logout();
		Assert.assertTrue(nsp.getAlertText().contains("Logout Successful"), "Logout Successfull! message is not displayed!");
	}
	
	@Test
	public void changeProfileImageTest() throws IOException, InterruptedException {
		this.driver.get(this.baseUrl + "guest-user/login-form");
		lcp.closePopup();
		loginPage.login(this.userName, this.password);
		Assert.assertTrue(nsp.getAlertText().contains("Login Successfull"), "Login successfull message is not displayed!");
		driver.navigate().to(baseUrl + "member/profile");
		profilePage.getUploadImageButton();
		profilePage.sendImage("img/avatar.png");
		Assert.assertTrue(nsp.getAlertText().contains("Profile Image Uploaded Successfully"), "Profile Image Uploaded Successfully message is not displayed!");
		WebElement msg = this.driver.findElement(By.xpath("//*[contains(@class, 'system_message')]"));
		waiter.until(ExpectedConditions.attributeToBe(msg, "style", "display: none;"));
		profilePage.deleteImage();
		msg = this.driver.findElement(By.xpath("//*[contains(@class, 'system_message')]"));
		Assert.assertTrue(nsp.getAlertText().contains("Profile Image Deleted Successfully"), "Profile Image Deleted Successfully message is not displayed!");
		waiter.until(ExpectedConditions.attributeToBe(msg, "style", "display: none;"));
		authPage.logout();
		Assert.assertTrue(nsp.getAlertText().contains("Logout Successful"), "Logout Successfull! message is not displayed!");
	}
	
}
