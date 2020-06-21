package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import bsh.This;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Homepage1 {
	
	WebDriver driver;
	
	public Homepage1(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//input[@name='q']") WebElement SearchBox;
	
	@FindBy(how=How.XPATH, using="//input[@name='btnK']") WebElement SearchButton;
	
	@FindBy(how=How.XPATH, using="//input[@name='btnK']") WebElement SearchButtn;
	
	public void setWebsite(String website){
	SearchBox.sendKeys(website);
	}

	public void clickButton(){
		SearchButton.click();
		}
	


}
