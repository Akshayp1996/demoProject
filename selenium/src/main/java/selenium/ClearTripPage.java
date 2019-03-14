package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClearTripPage {

	Common objcommon;

	public ClearTripPage() {

		objcommon = new Common();
	}

	public void clickLHSMenu(String Menu) {

		WebElement LHSMenu = objcommon.driver
				.findElement(By.xpath("//nav[@class='hasProductIcons']//a[@title='" + Menu + "']"));
		System.out.println(LHSMenu);
		LHSMenu.click();
		System.out.println("Click on LHS menu");

	}

	public void selectTravellers() {

	}

}
