package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();

		FileInputStream fis = new FileInputStream("src/main/java/resources/data.properties");

		prop.load(fis);

		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Java\\Automation\\drivers\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "D:\\Java\\Automation\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else {
			System.setProperty("webdriver.ie.driver", "D:\\Java\\Automation\\drivers\\IEDriverServer.exe");

			driver = new InternetExplorerDriver();

		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;

	}
	
	
	public String getScreenshotPath(String TCName,WebDriver driver) throws IOException {
		
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String file_name = System.getProperty("user.dir") + "\\reports\\"+TCName+".png";
		FileUtils.copyFile(src, new File(file_name));
		return file_name;
	}

}
