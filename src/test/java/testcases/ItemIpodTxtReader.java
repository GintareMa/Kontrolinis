package testcases;

import org.testng.annotations.Test;

import pages.CommonPages;
import utilities.FileReaderUtils;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class ItemIpodTxtReader {
	WebDriver driver;
	CommonPages co;
	
  @Test
  public void itemIpodTxtReader() throws IOException{
			List<String> testdata = FileReaderUtils.getTestData("src/test/resources/TesteData_5iPod.txt");
			
			System.out.println(testdata);
  }
  
  @BeforeClass (alwaysRun = true)
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  co = new CommonPages(driver);
	  driver.get("https://demo.opencart.com/");
  }

  @AfterClass (alwaysRun = true)
  public void afterClass() {
	  driver.close();
  }

}
