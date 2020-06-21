package Testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import configuration.base;


public class emumbaTest extends base {
	
	@Test
	public void herokuApp() throws InterruptedException, IOException {
		
		//////Opening new tab
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		
		driver.get("https://emumba-test.herokuapp.com/");
		driver.findElement(By.xpath("(//span[@class='MuiButton-label'])[3]")).click();
		driver.findElement(By.linkText("Not a user yet?")).click();
		
		
		
		//For Sign-up please add new information because excel information is already signed-up and getting at an error with excel information "Request failed with status code 400".
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("ahad");
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("ata");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ahad.ata@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@name='confirm_password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//span[text()='Sign Up']")).click();
		Thread.sleep(2000);
		
		//For Login please add new sign-up email and password
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ahad.ata@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		driver.findElement(By.xpath("//a[@href='/submit']")).click();
		//Getting detail from box for posting flyer
		String title = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/h6[1]")).getText();
		driver.findElement(By.xpath("(//textarea[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[1]")).sendKeys(title);
	    String honest=	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/span[1]")).getText();
	    String remember=	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/span[1]")).getText();
	    String behave = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/div[1]/span[1]")).getText();
		String Search = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[4]/div[1]/span[1]")).getText(); 
		String Read= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[5]/div[1]/span[1]")).getText();
		driver.findElement(By.xpath("(//textarea[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[3]")).sendKeys(honest+"\n"+remember+"\n"+behave+"\n"+Search+"\n"+Read);
		driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[1]")).sendKeys("30012345678");
		driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[2]")).sendKeys("Emumba Pvt. Limited, Korang Road I-10/3 Islamabad.");
		driver.findElement(By.xpath("(//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root')]//input)[3]")).sendKeys("hello there"+Keys.ENTER);
		driver.findElement(By.xpath("(//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root')]//input)[3]")).sendKeys("covid-19"+Keys.ENTER);
		driver.findElement(By.xpath("(//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root')]//input)[3]")).sendKeys("zara hut k"+Keys.ENTER);
	    //Posting flyer
		driver.findElement(By.xpath("//span[text()='Post']")).click();
		Thread.sleep(2000);
		
	    //After posting flyer clicking on Home button
		driver.findElement(By.xpath("(//span[@class='MuiButton-label']//a)[1]")).click();
		Thread.sleep(2000);
		
		//Capturing screenshot with newly created flyer
		String s= "flyer title";
		File scrfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		///Please just change the location where you want to save screenshots on your pc
		FileUtils.copyFile(scrfile,new File(("/Users/atiqraza/Desktop/automation/")+s+".png"));
		
		driver.findElement(By.xpath("//span[text()='Logout']")).click();
		
		driver.quit();
		///Because of limited time i could not use page object model here in this test case but in first test case i have used page object model.
	}

}
