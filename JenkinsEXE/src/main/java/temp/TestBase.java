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
	
	
	@BeforeMethod
	public void beforeMethodConfig() {
		String browserName = System.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.out.println(browserName);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}else if (browserName.equalsIgnoreCase("firefox")) {
			System.out.println(browserName);
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
