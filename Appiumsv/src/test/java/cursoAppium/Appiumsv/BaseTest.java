package cursoAppium.Appiumsv;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Pau\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("0.0.0.0").usingPort(4723).build();
		service.start();
		
		
		UiAutomator2Options options = new UiAutomator2Options();
		// Appium code -> Appium server -> Mobile
		options.setDeviceName("PauDevice");
		options.setApp("C:\\Users\\Pau\\eclipse-workspace\\Appiumsv\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
	
}
