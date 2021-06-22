package tests;

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
	
}
