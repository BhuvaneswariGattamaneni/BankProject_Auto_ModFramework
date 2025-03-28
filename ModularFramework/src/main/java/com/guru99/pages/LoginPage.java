package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(name = "uid")
	private WebElement userId;
	
	@CacheLookup
	@FindBy(name = "password")
	private WebElement userPassword;
	
	@CacheLookup
	@FindBy(name = "btnLogin")
	private WebElement loginButton;
	
	public void login(String username, String password) throws Exception {
		
		elementControl.sendText(userId, username);
		elementControl.sendText(userPassword, password);
		elementControl.clickButton(loginButton);
		Thread.sleep(5);
	}
	
}
