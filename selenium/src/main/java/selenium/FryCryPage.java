package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@SuppressWarnings("static-access")

public class FryCryPage implements TestData {

	Common objcommon;

	public FryCryPage() {

		objcommon = new Common();
	}

	// Links
	WebElement login = objcommon.driver.findElement(By.xpath("//div[@class='login']//span[text()='Login']"));
	WebElement linkSitemap = objcommon.driver.findElement(By.xpath("//div[@class='fc-footer']//a[text()='SITEMAP']"));

	// Input Boxes
	WebElement inpLoginEmailId = objcommon.driver
			.findElement(By.xpath("//div[@id='amt']//form[@id='frmLoginPopup']//input[@id='txtLUNm']"));
	WebElement inpLoginPassword = objcommon.driver
			.findElement(By.xpath("//div[@id='amt']//form[@id='frmLoginPopup']//input[@id='txtLPass']"));

	// CheckBoxes
	WebElement chkKeepMeLoggedIn = objcommon.driver
			.findElement(By.xpath("//div[@id='amt']//form[@id='frmLoginPopup']//div[@id='kpLogImg']"));

	// Buttons

	WebElement btnLogin = objcommon.driver
			.findElement(By.xpath("//div[@id='amt']//form[@id='frmLoginPopup']//input[@id='btnlogon']"));

	public void loginToFirstCry() {

		login.click();
		System.out.println("Click on Login link from to right corner");
		inpLoginEmailId.sendKeys(firstCryLogin.EmailId);
		System.out.println("Set email id");
		inpLoginPassword.sendKeys(firstCryLogin.Password);
		System.out.println("Set password");
		if (chkKeepMeLoggedIn.isSelected()) {
			chkKeepMeLoggedIn.click();
		}

		btnLogin.click();
		System.out.println("Click on Login");
		

	}

	public void selectTravellers() {

	}

}
