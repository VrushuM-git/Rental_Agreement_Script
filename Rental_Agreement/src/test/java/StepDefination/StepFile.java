package StepDefination;

import java.util.Iterator;

import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepFile {
	public WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@Given("Launch The Application")
	public void launch_the_application() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		String baseUrl = "https://www.multiliving.co.in/online-rental-agreement";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		}

	@SuppressWarnings("deprecation")
	@When("Hold and Handling the How It Works Pop-up")
	public void hold_and_handling_the_how_it_works_pop_up() throws InterruptedException {
		Thread.sleep(5000);	
		
		WebElement popup_Cancel = driver.findElement(By.xpath("//button[@data-testid='close-button']//*[local-name()='svg']"));

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String PopUpWindow = iterator.next();
		driver.switchTo().window(PopUpWindow);	
		
		popup_Cancel.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	   
	}

	@Then("Verify the Page Title")
	public void verify_the_page_title() {
		String ExpectedTitle = "Online Rental Agreement | Leave and License Rent Agreement - MultiLiving";
		Assert.assertEquals(driver.getTitle(),ExpectedTitle);
	}

	@Then("Basic Details - Filling the following details")
	public void basic_details_filling_the_following_details(DataTable dataTable) throws InterruptedException {
		WebElement partyType =  driver.findElement(By.cssSelector("#party_type"));
		partyType.sendKeys(dataTable.cell(1,0));
		Thread.sleep(300);
		
		WebElement firstName =  driver.findElement(By.cssSelector("#inputFirstName"));
		firstName .sendKeys(dataTable.cell(1,1));
		Thread.sleep(300);
		
		WebElement lastName =  driver.findElement(By.cssSelector("#inputLastName"));
		lastName.sendKeys(dataTable.cell(1,2));
		Thread.sleep(300);
		
		WebElement mobileNum =  driver.findElement(By.cssSelector("#inputMobile"));
		mobileNum .sendKeys(dataTable.cell(1,3));
		Thread.sleep(300);
		
		WebElement emailID =  driver.findElement(By.cssSelector("#inputMailId"));
		emailID.sendKeys(dataTable.cell(1,4));
		Thread.sleep(400);

	}


	 @Then("Click on Save and Continue")
	public void click_on_save_and_continue() {
		
		WebElement save_Click =  driver.findElement(By.cssSelector("#stepcta_1"));

		save_Click.click();

	    
	}

	@Then("Popup window is appear and Enter the mobile number {string}")
	public void popup_window_is_appear_and_enter_the_mobile_number(String mobileNumber) {
		WebElement mob_num_Enter = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String ModalWindow = iterator.next();
		driver.switchTo().window(ModalWindow);
		mob_num_Enter.sendKeys(mobileNumber);
	
	}

	@Then("Click on Send OTP")
	public void click_on_send_otp() {
		WebElement sendOTP = driver.findElement(By.xpath("//button[normalize-space()='Send OTP']"));
		sendOTP.click();
	}

	@SuppressWarnings("resource")
	@Then("Enter the OTP in Console so that user can complete authentication process")
	public void enter_the_otp_in_console_so_that_user_can_complete_authentication_process() throws InterruptedException {
		WebElement Enter_OTP = driver.findElement(By.xpath("//input[@placeholder='Enter OTP']"));
		Scanner sc = new Scanner(System.in); // scanner - class ,sc - obj,new -obj 
		System.out.println("Enter the OTP: ");
		String otp = sc.next();
		Enter_OTP.sendKeys(otp);
	
	}

	@Then("Click on Login")
	public void click_on_login() {
		WebElement Login_Click = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		Login_Click.click();
	    
	}
	
	@Then("save and continue")
	public void save_and_continue() {
		WebElement Save_continue = driver.findElement(By.xpath("//button[normalize-space()='Save and Continue']"));
		Save_continue.click();
	    
	}

}
