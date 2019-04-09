package StepDefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Util.Platform;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class GuiStepDefinition extends Platform {
	
	
static WebDriver driver;
	
	@Before
	public void initialize() {
		System.out.println("this is before class");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Usman\\eclipse-workspace\\FacebookBDD\\target\\chromedriver.exe");

		// Webdriver is interface
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void ending() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
		
	@Given("^enter first name \"([^\"]*)\"$")
		public void enterfname(String a) throws IOException {
		//driver.findElement(By.id("email")).sendKeys(a);
		findelement(driver, readprop("firstname")).sendKeys(a);
		
	}	

	@Given("^enter last name \"([^\"]*)\"$")
	public void enterlname(String a) throws IOException {
		findelement(driver, readprop("lastname")).sendKeys(a);
	}

	@Given("^enter email \"([^\"]*)\"$")
	public void enteremail(String a) throws IOException {
		findelement(driver, readprop("email")).sendKeys(a);
	}
	
	@When("^enter password \"([^\"]*)\"$")
	public void enterpw(String a) throws IOException {
		findelement(driver, readprop("newpw")).sendKeys(a);
	}
	
	@When("^select month \"([^\"]*)\"$")
	public void slmonth(String a) throws IOException {
		Select m=new Select(findelement(driver, readprop("month")));
		m.selectByVisibleText(a);
	}
	
	@When("^select day \"([^\"]*)\"$")
	public void slday(String a) throws IOException {
		Select d=new Select(findelement(driver, readprop("day")));
		d.selectByVisibleText(a);
	}
	
	@When("^select year \"([^\"]*)\"$")
	public void slyear(String a) throws IOException {
		Select y=new Select(findelement(driver, readprop("year")));
		y.selectByVisibleText(a);
	}
	
	@And("^Select gender \"([^\"]*)\"$")
	public void clickGender(String a) throws IOException {
		findelement(driver, a).click();
	}
	
	@And("^Click on Create Account$")
	public void clickcreatAcnt() throws IOException {
		findelement(driver, readprop("CreateAct")).click();
	}
	
	@Given("^typein first name \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_first_name_and(String a, String b) throws Throwable {
		findelement(driver, readprop("firstname")).sendKeys(a);
		findelement(driver, readprop("lastname")).sendKeys(b);
	    
	}
	
	@And("^Print error message$")
	public void printerror() throws IOException, InterruptedException {
		sleep(driver, 2);
		int x=34;
//		String gh=Integer.toString(x);
		String err= findelement(driver, readprop("errmsg")).getText();
	    Assert.assertTrue("Error Message Didn't Popup", err.contains("Please re-enter your email address.") );
}}