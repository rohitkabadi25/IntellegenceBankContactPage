package IntelligenceBank.ContactUs;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactUsPageObject;

public class ContactUsTest extends BaseTest {
	
	@Test
	
	public void contactUsForm() throws IOException {
		
		
		ContactUsPageObject obj = new ContactUsPageObject(driver);
		obj.goTo();
		obj.cookieAccept();
		obj.switchToFrame();
		obj.contactForm("TestName", "TestLastName", "Google", "testmail@test.com", "9022545484","Enquiry details test", "631422");
		
		// Taking screenshot and saving it on desktop
		getScreenshot(driver);
		
		// FirstName field mandatory assertion
		if (!assertFirstName(obj.firstNameField())) {
		    System.out.println("FirstName field is mandatory");
		    AssertJUnit.fail("FirstName field is mandatory");
		} else {
			 System.out.println("FirstName field is correct and not empty");
		    AssertJUnit.assertTrue(true);
		}
		
		// Email field format assertion
		if (!isValidEmail(obj.emailField())) {
		    System.out.println("Email field is not in correct format.");
		    AssertJUnit.fail("Email field is not in correct format.");
		} else {
		    System.out.println("Email field is in correct format.");
		    AssertJUnit.assertTrue(true);
		}
		
		// Mobile field format assertion
		if (!isValidMobile(obj.mobileField())) {
		    System.out.println("Mobile field is not in correct format.");
		    AssertJUnit.fail("Mobile field is not in correct format.");
		} else {
		    System.out.println("Mobile field is in correct format.");
		    AssertJUnit.assertTrue(true);
		}
		
	}
	

}
