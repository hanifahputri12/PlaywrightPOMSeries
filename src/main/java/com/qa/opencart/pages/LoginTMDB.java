package com.qa.opencart.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginTMDB {
	private Page page;
	
	private String clickLogin = "//a[@aria-label='Login']";
	private String accUsername = "//input[@id='username']";
	private String accPassword = "//input[@id='password']";
	private String loginButton = "//input[@id='login_button']";
	private String profileName = "//div[@class='content_wrapper flex']//a[contains(text(),'hanifahptri12')]";
	
	private String languageBtn = "li[class='translate'] div";
	private String fillLanguage = "#default_language_popup-list input";
	private String reloadBtn = "//a[normalize-space()='Reload Page']";
	private String welcomeSign = "//h2[normalize-space()='Welcome.']";
	
	//markMovie
	private String moviesTab = "a[aria-label='Film']";
	private String popularMovies ="//a[@href='/movie'][normalize-space()='Populer']";
	private String insideOut = "h2 a[title='Inside Out 2']";
	private String favBtn = "#favourite";
	private String profileBtn = "//span[@class='avatar background_color blue']";
	private String overviewTab = "//span[normalize-space()='Overview']";
	private String watchList = "#settings_tooltip";
	
	//markSeries
	private String seriesTab = "a[aria-label='Serial TV']";
	private String popularSeries = "//a[@href='/tv'][normalize-space()='Populer']";
	private String simpsons = "h2 a[title='Simpsons']";
	
	//filtering
	private String groupdownFilter = "//div[@class='group_dropdown filters']";
	private String filteringByPopularity = "#filter_by_popularity";
	private String filteringByReleaseDate = "#filter_by_release_date";
	private String filteringByCreatedAt = "#filter_by_created_at";

	
	
	public LoginTMDB(Page page) {
		this.page = page;
	}
	
	public boolean wantLogin (String appUsername, String appPassword) {
		page.click(clickLogin);
		page.fill(accUsername, appUsername);
		page.fill(accPassword, appPassword);
		page.click(loginButton);
		page.locator(profileName).waitFor();
		if (page.locator(profileName).isVisible()) {
			System.out.println("user is logged in successfully....");
			return true;
		}
		else {
			System.out.println("user is not logged in successfully....");
			return false;
		}

		
	}
	
	
	public boolean markMovie() {
		page.click(moviesTab);
		page.click(popularMovies);
		page.click(insideOut);
	    page.waitForTimeout(3000);
		page.locator(favBtn).click();
	    page.waitForTimeout(3000);
	    page.click(profileBtn);
	    page.waitForTimeout(5000);
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Daftar Tontonan")).click();
		page.locator(overviewTab).first().hover();
		page.getByText("Paling Disuka").first().hover();
	    page.locator("#new_shortcut_bar").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Film")).click();
		if (page.getByText("Inside Out 2").isVisible()) {
			return true;
		}
		else {
			return false;
		}
			
	}
	
	public boolean markSeries() {
		page.click(seriesTab);
		page.click(popularSeries);
		page.click(simpsons);
	    page.waitForTimeout(3000);
		page.locator(favBtn).click();
	    page.waitForTimeout(3000);
	    page.waitForSelector(profileBtn).click();
	    page.waitForTimeout(5000);
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Daftar Tontonan")).click();
		page.locator(overviewTab).first().hover();
		page.getByText("Paling Disuka").first().hover();
		page.locator("#new_shortcut_bar").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Serial TV")).click();
		if (page.getByText("Simpsons").isVisible()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public String filteringMoviesByPopularity() {
		page.waitForTimeout(3000);
		page.pause();
		page.click(profileBtn);
		page.waitForTimeout(5000);
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Daftar Tontonan")).click();
		page.locator(overviewTab).first().hover();
		page.getByText("Paling Disuka").first().hover();
		page.locator("#new_shortcut_bar").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Film")).click();
	    page.hover(groupdownFilter);
		page.click(filteringByPopularity);
		String url = page.url();
		System.out.println(url);
		return url;
	}
	
	public String filteringMoviesByReleaseDate() {
//		page.waitForTimeout(3000);
//		page.pause();
//		page.click(profileBtn);
//		page.waitForTimeout(5000);
//		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Daftar Tontonan")).click();
//		page.locator(overviewTab).first().hover();
//		page.getByText("Paling Disuka").first().hover();
//		page.locator("#new_shortcut_bar").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Film")).click();
	    page.hover(groupdownFilter);
		page.click(filteringByReleaseDate);
		String url = page.url();
		System.out.println(url);
		return url;
	}
	
	public String filteringMoviesByCreatedAt() {
//		page.waitForTimeout(3000);
//		page.pause();
//
//		page.click(profileBtn);
//		page.waitForTimeout(5000);
//		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Daftar Tontonan")).click();
//		page.locator(overviewTab).first().hover();
//		page.getByText("Paling Disuka").first().hover();
//		page.locator("#new_shortcut_bar").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Film")).click();
	    page.hover(groupdownFilter);
		page.click(filteringByCreatedAt);
		String url = page.url();
		System.out.println(url);
		return url;
	}

}
