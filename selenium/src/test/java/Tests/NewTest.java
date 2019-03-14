package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class NewTest {

	public WebDriver driver;
	WebDriverWait webWait;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@BeforeClass
	public void beforeClass() {
		driver.get("https://www.cleartrip.com");
	}

	@BeforeMethod
	public void beforeMethod() {

		webWait = new WebDriverWait(driver, 90);

	}

	@Test
	public void Test() throws InterruptedException {
		this.firstPage();
		this.secondPage();
		this.thirdPage();
		this.fourthPage();
		this.fifthPage();
		this.sixthPage();
		this.seventhPage();
	}

	@AfterMethod
	public void afterMethod() {

		// driver.quit();
	}

	public void firstPage() throws InterruptedException {

		driver.findElement(By
				.xpath("//li[@class='flightApp']/a[@title='Find flights from and to international destinations around the world']"))
				.click();

		driver.findElement(By.xpath("//input[@id='RoundTrip']")).click();
		driver.findElement(By.xpath("//input[@id='FromTag']"))
				.sendKeys("Mumbai, IN - Chatrapati Shivaji Airport (BOM)");
		driver.findElement(By.xpath("//input[@id='ToTag']")).sendKeys("New Delhi, IN - Indira Gandhi Airport (DEL)");

		// set date

		String returnDate = getFutureOrBackDateInSpecifiedFormat("E, dd MMM yyyy", +6);

		driver.findElement(By.xpath("//input[@id='DepartDate']"))
				.sendKeys(getFutureOrBackDateInSpecifiedFormat("E, dd MMM yyyy", +5));
		WebElement ReturnDate = driver.findElement(By.xpath("//input[@id='ReturnDate']"));
		ReturnDate.clear();
		ReturnDate.sendKeys(returnDate);

		// select adults
		WebElement adult = driver.findElement(By.xpath("//select[@id='Adults']"));
		Select se = new Select(adult);
		se.selectByValue("2");

		// search flight button
		driver.findElement(By.xpath("//input[@id='SearchBtn']")).click();

		Thread.sleep(50000);
	}

	public void secondPage() throws InterruptedException {
		// select 0 stops
		driver.findElement(By.xpath("//input[@name='stops']//following-sibling::label[contains(text(),'0')]")).click();

		// Select trips
		// Select Deaprture flight
		List<WebElement> departureFlightName = driver
				.findElements(By.xpath("(//nav[@class='listViewNav'])[2]//td/span"));
		// div[@class='colZero leg col12']//ul[@class='listView
		// flights']//td/span
		String flightName = "";
		int counter = 0;
		for (WebElement webElement : departureFlightName) {
			System.out.println(webElement.getText());
			if (webElement.getText().contains("IndiGo")) {
				flightName = "IndiGo";
				break;
			}

			if (webElement.getText().contains("SpiceJet")) {
				flightName = "SpiceJet";
				break;
			}

		}
		System.out.println(flightName);
		for (WebElement webElement : departureFlightName) {
			if (webElement.getText().contains(flightName)) {
				counter++;
				if (counter == 2) {

					webElement.click();
					System.out.println("Departure -----------------CLicked");
				}
			}
		}

		Thread.sleep(10000);

		// Select Return flight
		List<WebElement> returnFlightName = driver.findElements(By.xpath("(//nav[@class='listViewNav'])[3]//td/span"));// div[@class='colZero
																														// leg
																														// col12']//ul[@class='listView
																														// flights']//td/span
		String flightName1 = "";
		int counter1 = 0;
		for (WebElement webElement : returnFlightName) {
			System.out.println(webElement.getText());
			if (webElement.getText().contains("GoAir")) {
				flightName1 = "GoAir";
				break;
			}

			if (webElement.getText().contains("Jet Airways")) {
				flightName1 = "Jet Airways";
				break;
			}

		}
		System.out.println(flightName1);
		for (WebElement webElement : returnFlightName) {
			if (webElement.getText().contains(flightName1)) {
				counter1++;
				if (counter1 == 2) {

					webElement.click();
					System.out.println("Return -----------------CLicked");
				}
			}
		}

		// click on book
		driver.findElement(By.xpath("(//button[@class='booking fRight'])[2]")).click();
	}

	public void thirdPage() throws InterruptedException {

		// uncheck Insurance checkbox
		webWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='insurance_box']")));
		WebElement insurance = driver.findElement(By.xpath("//input[@id='insurance_box']"));
		if (insurance.isSelected()) {
			insurance.click();
		}

		// click continue booking
		webWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='itineraryBtn']")));
		driver.findElement(By.xpath("//input[@id='itineraryBtn']")).click();

	}

	public void fourthPage() throws InterruptedException {

		// set email id
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("abc@abc.com");
		// click on continue button
		driver.findElement(By.xpath("//input[@id='LoginContinueBtn_1']")).click();
		Thread.sleep(30000);

	}

	public void fifthPage() throws InterruptedException {

		// set traveler names
		// Adult1
		WebElement title1 = driver.findElement(By.xpath("//select[@id='AdultTitle1']"));
		webWait.until(ExpectedConditions.visibilityOf(title1));

		Select sel1 = new Select(title1);
		sel1.selectByValue("Mr");
		driver.findElement(By.xpath("//input[@name='AdultFname1']")).sendKeys("abc");
		driver.findElement(By.xpath("//input[@name='AdultLname1']")).sendKeys("efg");

		// Adult2
		WebElement title2 = driver.findElement(By.xpath("//select[@id='AdultTitle2']"));
		Select sel2 = new Select(title2);
		sel2.selectByValue("Ms");
		driver.findElement(By.xpath("//input[@name='AdultFname2']")).sendKeys("pqr");
		driver.findElement(By.xpath("//input[@name='AdultLname2']")).sendKeys("xyz");

		// set mobile no
		driver.findElement(By.xpath("//input[@name='contact1']")).sendKeys("9876543210");

		// click on countinue
		driver.findElement(By.xpath("//input[@id='travellerBtn']")).click();

	}

	public void sixthPage() throws InterruptedException {

		webWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li//a[text()='Net Banking']")));

		// select 'Net Banking' payment mode
		driver.findElement(By.xpath("//ul/li//a[text()='Net Banking']")).click();

		// select bank
		WebElement Bank = driver.findElement(By.xpath("//select[@id='transferBank']"));
		Select sel3 = new Select(Bank);
		sel3.selectByVisibleText(("Kotak Bank"));

		// click on Make Payment
		driver.findElement(By.xpath("//input[@id='paymentSubmit']")).click();

	}

	public void seventhPage() throws InterruptedException {

		webWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@id='header-main']//img")));

		// verify title
		WebElement title = driver.findElement(By.xpath("//header[@id='header-main']//img"));
		webWait.until(ExpectedConditions.visibilityOf(title));
		System.out.println(title.getAttribute("title"));
		System.out.println(title);
		if (title.equals("Kotak")) {
			System.out.println("Verifiction done..");
		} else {
			System.out.println("Title does not matched ");
		}

	}

	public static String getFutureOrBackDateInSpecifiedFormat(String dateFormat, int NoOfFutureDay) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, NoOfFutureDay);
		String futureDate = new SimpleDateFormat(dateFormat).format(c.getTime()).toString();
		return futureDate;
	}

}
