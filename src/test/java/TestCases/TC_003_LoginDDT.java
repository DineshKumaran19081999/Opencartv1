package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.MyAccountPage;
import utilities.DataProviders;

public class TC_003_LoginDDT extends Baseclass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verify_loginDTT(String email,String pwd,String exp)
	{
		logger.info("**** Started TC_003_LoginDDT****");
		
		try{
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		MyAccountPage mcc=new MyAccountPage(driver);
		boolean targetPage=mcc.isMyAccountPageExists();
		
		if (exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				Assert.assertTrue(true);
				mcc.clickLogout();
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				Assert.assertTrue(false);
				mcc.clickLogout();
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finished TC_003_LoginDDT**** ");
		
	}
}
