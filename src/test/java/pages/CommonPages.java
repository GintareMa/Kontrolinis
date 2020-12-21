package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonPages {
	WebDriver driver = null;
	
	public CommonPages(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getDisclosureConfirmBtn() {
		return driver.findElement(By.id("disclosure-confirm"));
	}
}
