package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Common {

	public static WebDriver driver;
	// WebDriverWait webWait = new WebDriverWait(driver, 90);
	ChromeOptions options;

	public void luanchBrowser() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\chromedriver.exe");
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

	}

	public void setURL() throws InterruptedException {
		driver.get("http://www.firstcry.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

}
