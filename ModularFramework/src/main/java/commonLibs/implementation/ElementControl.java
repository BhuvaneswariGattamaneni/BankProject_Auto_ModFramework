package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementControl {
	
	WebDriver driver;

	public ElementControl(WebDriver driver) {
	   this.driver = driver;
	}

	public void clickButton(WebElement element) {
	   element.click();
	}

	public void clear(WebElement element) {
	   element.clear();
	}

	public void sendText(WebElement element, String text) {
	   element.sendKeys(text);
	}

	public boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}

	public boolean isDisplayed(WebElement element) {
	   return element.isDisplayed();
	}

	public void acceptAlert() {
	   driver.switchTo().alert().accept();
	}

	public void alertMessage() {
	   driver.switchTo().alert().getText();
	}

	public void selectDropdown(WebElement element, String text) {
	   Select select = new Select(element);
	   select.selectByVisibleText(text);
	}

}
