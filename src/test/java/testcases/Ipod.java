package testcases;

import org.testng.annotations.Test;

import pages.CommonPages;
import pages.IpodPage;
import utilities.WaitUtils;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Ipod {
	WebDriver driver;
	CommonPages co;
	IpodPage po;
	
	
	Random rand = new Random();
	int emailNr = 0;
	
	
  @Test
  public void findAllMp3List() {
	  assertEquals(po.getIpodClassicTitle(), "iPod Classic");
	  System.out.println(po.getIpodClassicTitle());
  }
  
  @Test (groups = "smoke")
  public void openIpodClassicItem() {
	  po.getIpodClassicItem().click();
	  po.getIpodBtnToWishList().click();
	  WaitUtils.waitForJS(driver);
	  assertTrue(po.getMessageAddIpodClassToWishlist().contains("iPod Classic"));
	  driver.navigate().refresh();
	  po.getBtnAddToCart().click();
	  WaitUtils.waitForJS(driver);
	  assertTrue(po.getMessageItemInTheCart().contains("iPod"));	  
  }
  
  @Test 
  public void openIpodNanoItem() {
	  po.getIpodNanoItem().click();
	  po.getIpodBtnToWishList().click();
	  WaitUtils.waitForJS(driver);
	  assertTrue(po.getMessageAddIpodClassToWishlist().contains("iPod Nano"));
	  driver.navigate().refresh();
	  po.getBtnAddToCart().click();
	  WaitUtils.waitForJS(driver);
	  assertTrue(po.getMessageItemInTheCart().contains("iPod"));	  
  }
  

  
  @BeforeClass(alwaysRun = true)
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  po = new IpodPage(driver);
	  co = new CommonPages(driver);
	  
	  driver.get("https://demo.opencart.com/");
	  po.getMp3ArticleBtn().click();
	  po.getShowAllMp3Btn().click();
	  
	  
  }

  @AfterClass (alwaysRun = true)
  public void afterClass() {
	  driver.close();
  }

}
