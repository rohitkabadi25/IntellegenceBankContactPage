package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponent.AbstractComponent;

public class ContactUsPageObject extends AbstractComponent {
	
	
	WebDriver driver;
	
	public ContactUsPageObject(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id='cookie_action_close_header']")
	WebElement cookieAccept;
	
	@FindBy(xpath="//div[@class='et_pb_code_inner']/iframe")
	WebElement frame;
	
	@FindBy(xpath="//input[@name='First_Namepi_First_Name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='Last_Namepi_Last_Name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='Companypi_Company']")
	WebElement companyName;
	
	@FindBy(xpath="//input[@name='Emailpi_Email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='941293_138982pi_941293_138982']")
	WebElement mobile;
	
	@FindBy(name="941293_138980pi_941293_138980")
	WebElement countryDropdown;
	
	@FindBy(xpath="//textarea[@name='941293_138986pi_941293_138986']")
	WebElement enquiryDetails;
	
	@FindBy(css="label.inline")
	WebElement checkbox;
	
	
	public void contactForm(String userFirstName,String userLastName,String userCompanyName,String userEmail,String userMobile, String userEnquiryDetails, String userCountry) {
		
		firstName.sendKeys(userFirstName);
		lastName.sendKeys(userLastName);
		companyName.sendKeys(userCompanyName);
		email.sendKeys(userEmail);
		mobile.sendKeys(userMobile);
		enquiryDetails.sendKeys(userEnquiryDetails);
		checkbox.click();
		
		Select s = new Select(countryDropdown);
		s.selectByValue(userCountry);
	}
	
	public void goTo() {
		driver.get("https://www.intelligencebank.com/contact-us/");
	}
	
	public void cookieAccept() {
		waitForWebElementToAppear(cookieAccept);
		cookieAccept.click();
	}
	
	public void switchToFrame() {
		driver.switchTo().frame(frame);
	}
	
	
	
	public String firstNameField() {
		String firstNameField = firstName.getAttribute("value");
		return firstNameField;
		}
	
	public String emailField() {
	String emailField = email.getAttribute("value");
	return emailField;
	}
	
	public String mobileField() {
		String mobileField = mobile.getAttribute("value");
		return mobileField;
		}

}
