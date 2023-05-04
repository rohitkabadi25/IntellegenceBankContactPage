package IntelligenceBank.ContactUs;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	public WebDriver driver;
	
	@BeforeMethod(alwaysRun= true)
	public void initializeDriver() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterMethod(alwaysRun= true)
	public void tearDown() {
		
		driver.close();
	}
	
		public void getScreenshot(WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.home") + "/Desktop/screenshot.png");
		FileUtils.copyFile(source, file);
	
		
	}
		
		// Function to validate email address format
		public boolean isValidEmail(String email) {
		    // Check if email address contains '@' and '.'
		    if (email.contains("@") && email.contains(".")) {
		        return true;
		    } else {
		        return false;
		    }
		}

		// Function to validate mobile number format
		public boolean isValidMobile(String mobile) {
		    // Check if mobile number contains only digits and '+' symbol
		    if (mobile.matches("[0-9+]+")) {
		        return true;
		    } else {
		        return false;
		    }
		}
		
		public boolean assertFirstName(String firstName) {
			if (firstName.isEmpty()) {
		        return false;
		    } else {
		        return true;
		    }
		}
	
	

}
