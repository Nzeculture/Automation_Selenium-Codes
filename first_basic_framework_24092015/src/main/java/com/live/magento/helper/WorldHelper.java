package com.live.magento.helper;

import com.live.magento.browsers.Browsers;
import com.live.magento.pages.AbstractPage;
import com.live.magento.pages.HomePage;
import com.live.magento.pages.MyAccountPage;
import com.live.magento.pages.SearchResultPage;
import com.live.magento.pages.WelcomePage;

public class WorldHelper extends Browsers{
	
	
	private AbstractPage abstractPage;
	private HomePage homePage;
	private MyAccountPage myAccountPage;
	private WelcomePage welcomePage;
	private SearchResultPage searchResultPage;
	
	public WorldHelper(){
		instatiateDriver();
	}
	
	
	
	public AbstractPage getAbstractPage(){
		if(abstractPage == null){
			abstractPage = new AbstractPage(driver);
		}
		return abstractPage;
	}
	
	public HomePage getHomePage(){
		if(homePage == null){
			homePage = new HomePage(driver);
		}
		return homePage;
	}
	
	public MyAccountPage getMyAccountPage(){
		if(myAccountPage == null){
			myAccountPage = new MyAccountPage(driver);
		}
		return myAccountPage;
	}
	
	public WelcomePage getWelcomePage(){
		if(welcomePage == null){
			welcomePage = new WelcomePage(driver);
		}
		return welcomePage;
	}
	
	public SearchResultPage getSearchResultPage(){
		if(searchResultPage == null){
			searchResultPage = new SearchResultPage(driver);
		}
		return searchResultPage;
	}
	

}
