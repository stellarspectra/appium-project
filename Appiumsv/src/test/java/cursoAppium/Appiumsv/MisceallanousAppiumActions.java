package cursoAppium.Appiumsv;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MisceallanousAppiumActions extends BaseTest{
	
	@Test
	public void Miscellaneous() throws MalformedURLException {
	
		
		//App package - ir a un menu predeterminado sin pasar por todo el menu
		//en consola:
		// 1- asegurarse del device: adb device
		// 2- adb shell dumpsys window | find "mCurrentFocus"
		// 3- lo que está antes del barra es el paquete y lo que está después es la actividad
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
				
		//tagName[@attribute='value'] []
		//driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		
		// rotar el celular
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);
			
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		
		//copy paste
		//copy to clipboard - paste it clipboard
		driver.setClipboardText("PauWiFi");
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	
		//Diferentes main buttons
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

	
		
	
	}
}
