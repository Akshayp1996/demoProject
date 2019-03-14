package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import selenium.ClearTripPage;
import selenium.Common;
import selenium.TestData;

public class Hotel_Test implements TestData {
	public WebDriver driver;
	Common objCommon;
	ClearTripPage objClearTripPage;

	@BeforeTest
	public void beforeTest() {
		objCommon = new Common();
		objClearTripPage = new ClearTripPage();

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
		objClearTripPage.clickLHSMenu(clearTrip.LHSMenuTitle);

	}

	@AfterClass
	public void afterClass() {
	}

}
