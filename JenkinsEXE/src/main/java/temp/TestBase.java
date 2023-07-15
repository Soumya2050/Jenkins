package temp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {
	WebDriver driver;
	
	@Parameters("BrowserName")
	@BeforeMethod
	public void beforeMethodConfig(String BrowserName) {
		String browserName = BrowserName != null? BrowserName:System.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			System.err.println("The browser name is null from the jenkins");
		}
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}
	@AfterMethod
	public void afterMethodConfig() {
		driver.quit();
	}
}
