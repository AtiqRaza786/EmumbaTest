package Testcases;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import configuration.base;
import pageObject.Homepage1;

public class AfterLife extends base {

	@Test
	public void Browse() throws Exception {
		///Passing the path of excel file here and please give the path of your excel file here
		fis=new FileInputStream("/Users/atiqraza/Desktop/Emumba/qaautomation (1).xlsx");
		XSSFWorkbook wkWorkbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=wkWorkbook.getSheet("Input");

		///Getting the Rows and Cells here from excel sheet
		XSSFRow row0=sheet.getRow(0);
		XSSFCell cellUrl=row0.getCell(1);
		String Url= cellUrl.getStringCellValue();

		///Getting the Rows and Cells here from excel sheet
		XSSFRow row1=sheet.getRow(1);
		XSSFCell cellSite=row1.getCell(1);
		String Website= cellSite.getStringCellValue();

		///Launching chrome driver here
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		///Getting URL from excel sheet and launching here 
		driver.get(Url);

		///Getting locators from Page Object Model
		Homepage1 loginpage = PageFactory.initElements(driver, Homepage1.class);
		loginpage.setWebsite(Website);
		loginpage.clickButton();


        ////Verifying page title for test case pass or fail result
		driver.findElement(By.partialLinkText("After Life (TV Series 2019– ) - IMDb")).click();
		String ExpectedTitle ="After Life (TV Series 2019– ) - IMDb";
		String ActualTitle=driver.getTitle();
		assertEquals(ActualTitle, ExpectedTitle);


	}





}
