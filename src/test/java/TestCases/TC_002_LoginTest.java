package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.MyAccountPage;

public class TC_002_LoginTest extends Baseclass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("****Starting TC_002_LoginTest");
		
		try {
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage mcc=new MyAccountPage(driver);
		boolean targetpage=mcc.isMyAccountPageExists();
		Assert.assertTrue(targetpage);
		//Assert.assertEquals(targetpage, true, "Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		logger.info("****Finished TC_002_LoginTest ****");
		
	}
	
	

}
