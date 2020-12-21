package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IpodPage {
	WebDriver driver = null;
	
	public IpodPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public WebElement getMp3ArticleBtn() {
		return driver.findElement(By.cssSelector("#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(8) > a"));
	}
	
	public WebElement getShowAllMp3Btn() {
		return driver.findElement(By.linkText("Show All MP3 Players"));
	}
	
	public String getIpodClassicTitle() {
		return driver.findElement(By.cssSelector("#content > div:nth-child(8) > div:nth-child(1) > div > div:nth-child(2) > div.caption > h4")).getText();
	}
	
	public WebElement getIpodClassicItem() {
		return driver.findElement(By.cssSelector("#content > div:nth-child(8) > div:nth-child(1) > div > div.image > a > img"));
	}
	
	public WebElement getIpodBtnToWishList() {
		return driver.findElement(By.cssSelector("#content > div > div.col-sm-4 > div.btn-group > button:nth-child(1)"));
	}
	
	
	public String getMessageAddIpodClassToWishlist() {
	return driver.findElement(By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible > a:nth-child(4)")).getText();

	}
	
	
	
	public WebElement getBtnAddToCart() {
		return driver.findElement(By.id("button-cart"));
	}
	
	public String getMessageItemInTheCart() {
		return driver.findElement(By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible > a:nth-child(1)")).getText();
	}
	
	public WebElement getIpodNanoItem() {
		return driver.findElement(By.cssSelector("#content > div:nth-child(8) > div:nth-child(2) > div > div.image > a > img"));
	}
}




