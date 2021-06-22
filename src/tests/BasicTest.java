package tests;

import java.util.concurrent.TimeUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import pages.AuthPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;


public abstract class BasicTest {
	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected WebDriverWait waiter;
	protected String baseUrl = "http://demo.yo-meals.com/";
	protected String userName = "customer@dummyid.com";
	protected String password = "12345678a";
	protected LoginPage loginPage;
	protected MealPage mealPage;
	protected NotificationSystemPage nsp;
	protected AuthPage authPage;
	protected ProfilePage profilePage;
	protected LocationPopupPage lcp;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(this.baseUrl);
//		this.pt = new ProfileTest(baseUrl, userName, password);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);	
		js = (JavascriptExecutor) this.driver;
		waiter = new WebDriverWait(driver, 30, 300);
		loginPage = new LoginPage(driver, js, waiter);
		mealPage = new MealPage(driver, js, waiter);
		nsp = new NotificationSystemPage(driver, js, waiter);
		authPage = new AuthPage(driver, js, waiter);
		profilePage = new ProfilePage(driver, js, waiter);
		lcp = new LocationPopupPage(driver, js, waiter);
	}
	
	
	
	@AfterMethod
	public void afterTest(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile,
					new File("C:\\Users\\Hp\\Desktop\\projekti\\itbootcamp\\screenshots\\screenshot.png"));
		} else {
			
		}
		this.driver.quit();	
	}
}
