package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginTMDBTest extends BaseTest{
	
//	private LoginTMDB loginTMDB;
	
//	public void doLoginTest() {
//		Assert.assertTrue(loginTMDB.wantLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
//	}
	
//	public void changeLanguageTest() {
//		Assert.assertTrue(loginTMDB.changeLanguage("indo"));
//	}
	
	@Test(enabled=false)
	public void markMoviesTest() {
		Assert.assertTrue(loginTMDB.markMovie());
	}
	
	@Test(enabled=false)
	public void markSeriesTest() {
		Assert.assertTrue(loginTMDB.markSeries());
	}
	
	@Test(priority=1)
	public void filteringMoviesByPopularityTest() {
		String urlResult = loginTMDB.filteringMoviesByPopularity();
		Assert.assertTrue(urlResult.contains("sort_by=popularity"));
	}
	@Test(priority=2)
	public void filteringMoviesByReleaseDateTest() {
		String urlResult = loginTMDB.filteringMoviesByReleaseDate();
		Assert.assertTrue(urlResult.contains("sort_by=release_date"));
	}
	@Test(priority=3)
	public void filteringMoviesByCreatedAtTest() {
		String urlResult = loginTMDB.filteringMoviesByCreatedAt();
		Assert.assertTrue(urlResult.contains("sort_by=created_at"));
	}

}
