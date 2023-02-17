package cursoAppium.Appiumsv;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class MobileBrowserTest extends BrowserMobileBaseTest{

	@Test
	public void browserTest() {
		
//		driver.get("http://google.com");
//		System.out.println(driver.getTitle());
//		driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/products");
		driver.findElement(By.xpath("//span[@class='navbar-toggle-icon']")).click();
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
						
		String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
		//Assert.assertEquals(text, "Devops");
		
		
	}
}
