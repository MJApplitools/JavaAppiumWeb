package Applitools.AppiumWebJavaTutorial;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.applitools.eyes.appium.Eyes;

import io.appium.java_client.ios.IOSDriver;

public class IosTest {

	public static void IosTestExample() throws MalformedURLException {
		Eyes eyes = new Eyes(); 
		eyes.setApiKey("API Key");
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformVersion", "12.1");
        dc.setCapability("platformName", "iOS");
        dc.setCapability("automationName", "XCUITest");
        dc.setCapability("deviceName", "iPad (6th generation)");
        dc.setCapability("browserName", "Safari"); 
        
        IOSDriver<WebElement> driver = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc); 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			
			eyes.open(driver, "test", "Test"); 
			driver.get("https://www.facebook.com");
			eyes.checkWindow("Home Page");
			eyes.close();
			
		} catch( Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
			eyes.abortIfNotClosed();
			System.exit(0);
		}
	}
}
