package configuration;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.springframework.util.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pageObject.Homepage1;

public class base {


	public static WebDriver driver;

	public static FileInputStream fis;



        ///Capturing the Screenshots of Fail test cases.
	    public static void getScreenshot(String s) throws IOException {
		File scrfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		///Please just change the location where you want to save screenshots on your pc
		FileUtils.copyFile(scrfile,new File(("/Users/atiqraza/Desktop/automation/")+s+".png"));

	}

}
