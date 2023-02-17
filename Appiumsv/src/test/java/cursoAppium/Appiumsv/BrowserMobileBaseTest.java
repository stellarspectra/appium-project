package cursoAppium.Appiumsv;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class BrowserMobileBaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Pau\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("0.0.0.0").usingPort(4723).build();
		service.start();
		
		
		UiAutomator2Options options = new UiAutomator2Options();
		// Appium code -> Appium server -> Mobile
		options.setDeviceName("PauDevice");
		options.setChromedriverExecutable("C:\\Users\\Pau\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		options.setCapability("browserName", "Chrome");
		
		
		//verificar reinstall de apk
		//install > prueba > uninstall
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	
	public Double getFormattedAmount(String amountString) {
		Double price = Double.parseDouble(amountString.substring(1));
		return price;
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
	
}
