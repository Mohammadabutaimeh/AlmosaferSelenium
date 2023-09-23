import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlmosaferTest {

	WebDriver driver = new ChromeDriver();
	SoftAssert myAssertion = new SoftAssert();
	String ExpectedLanguage = "ar";
	String ExpectedCurrency = "SAR";
	String ExpectedAria_Selected = "true";

	
	@BeforeTest
	public void myBeforeTest() {
		
		driver.manage().window().maximize();
	}

	@Test()
	public void myTest() {

		driver.get("https://global.almosafer.com/ar");
		driver.findElement(By.className("cta__image")).click();
		String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");

		myAssertion.assertEquals(ActualLanguage, ExpectedLanguage, "this to check if the defualt language is Arabic ");
		myAssertion.assertAll();

	}

	@Test()
	public void myTest1() {

		String ActualCurrency = driver.findElement(By.className("sc-dRFtgE")).getText();

		myAssertion.assertEquals(ActualCurrency, ExpectedCurrency, "this to check if the defualt Currency is SAR ");
		myAssertion.assertAll();

	}
	@Test()
	public void myTest2() {

		String ActualAria_Selected = driver.findElement(By.id("uncontrolled-tab-example-tab-flights")).getAttribute("aria-selected");

		myAssertion.assertEquals(ActualAria_Selected, ExpectedAria_Selected,"this to check if flight tab is selected by defualt");
		myAssertion.assertAll();

	}

	@AfterTest
	public void myAfterTest() {
	}

}
