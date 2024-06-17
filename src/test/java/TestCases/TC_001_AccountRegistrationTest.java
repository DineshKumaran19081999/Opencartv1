package TestCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageobject.AccountRegistrationPage;
import pageobject.HomePage;

public class TC_001_AccountRegistrationTest extends Baseclass{
	
	
	
	
	@Test(groups={"Regression","Master"})
	public void HomePageLogin()
	{
		
		logger.info("****Starting TC_001_AccountRegistrationTest****");
		try {
		
		HomePage hp=new HomePage(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		hp.clickMyAccount();
		logger.info("****Clicked on MyAccount Link****");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		hp.clickRegister();
		logger.info("****Clicked on MyRegister link****");
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		AccountRegistrationPage rp = new AccountRegistrationPage(driver);
		
		logger.info("****Provinding customer details****");
		
		rp.setFirstName(randomeString().toUpperCase());
		rp.setLastName(randomeString().toUpperCase());
		rp.setEmail(randomeString()+"@gmail.com");
		rp.setTelephone(randomeNumber());
		
		String pwd = randomeAlphaNumeric();
		
		rp.setPassword(pwd);
		rp.setConfirmPassword(pwd);
		rp.setPrivacyPolicy();
		rp.ClickContinue();
		
		logger.info("****Validating expected message****");
		String confirm_msg=rp.getConfirmationMsg();
		if(confirm_msg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("***Test failed***");
			logger.debug("***Debug logs***");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		finally {
		logger.info("****Finished TC_001_AccountRegistrationTest****");
		}
		
	}
	
	
	

}
