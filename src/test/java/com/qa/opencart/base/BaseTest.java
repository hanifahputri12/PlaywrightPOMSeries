package com.qa.opencart.base;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginTMDB;


public class BaseTest {

	PlaywrightFactory pf;
	Page page;
	protected Properties prop;

	protected HomePage homePage;
	protected LoginTMDB loginTMDB;


	@Parameters({ "browser" })
	@BeforeTest
	public void setup(String browserName) {
		pf = new PlaywrightFactory();

		prop = pf.init_prop();

		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}

		page = pf.initBrowser(prop);
//		homePage = new HomePage(page);
		loginTMDB = new LoginTMDB(page);
		
		Assert.assertTrue(loginTMDB.wantLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));

	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}