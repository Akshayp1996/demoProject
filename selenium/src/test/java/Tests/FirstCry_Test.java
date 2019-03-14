package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import selenium.FryCryPage;
import selenium.Common;
import selenium.TestData;

public class FirstCry_Test implements TestData {
	public WebDriver driver;
	Common objCommon;
	FryCryPage objFryCryPage;

	@BeforeTest
	public void beforeTest() {
		objCommon = new Common();
		objFryCryPage = new FryCryPage();

	}

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		objCommon.luanchBrowser();
		objCommon.setURL();

	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@Test
	public void bookHotel() throws InterruptedException {
		System.out.println("Hello");
		objFryCryPage.loginToFirstCry();

	}

	@AfterClass
	public void afterClass() {
	}

}
