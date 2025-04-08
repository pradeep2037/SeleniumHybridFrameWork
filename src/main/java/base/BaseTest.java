package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import exceptions.InvalidBrowserException;
import utils.ExtentManager;

public class BaseTest {

	public static FileInputStream fis = null;
	public static Properties configProperties = null;

	public static FileInputStream fis2 = null;
	public static Properties locatorsProperties = null;

	public static WebDriver driver = null;
	public static ExtentReports reports;
	public static ExtentTest test;

	@BeforeTest
	public void beforeTest() {
		
		
		
		try {
			fis = new FileInputStream("Properties\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		configProperties = new Properties();

		try {
			configProperties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fis2 = new FileInputStream("Properties\\locators.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		locatorsProperties = new Properties();

		try {
			locatorsProperties.load(fis2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		reports = ExtentManager.getReports();
	}

	@BeforeMethod
	public void initialSetUp(Method method) {
		
		test = reports.createTest(method.getName());


		String browserName = configProperties.getProperty("browser");
		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();
			test.log(Status.INFO, browserName + " browser is started...");
			break;

		case "edge":
			driver = new EdgeDriver();
			test.log(Status.INFO, browserName + " browser is started...");
			break;

		case "firefox":
			driver = new FirefoxDriver();
			test.log(Status.INFO, browserName + " browser is started...");
			break;

		default:
			try {
				throw new InvalidBrowserException();
			} catch (InvalidBrowserException e) {
				e.getMessage();
			}

			break;
		}

		driver.get(configProperties.getProperty("url"));
		test.log(Status.INFO, " App is launched using url "+configProperties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Long.parseLong(configProperties.getProperty("implicitWait"))));
	}

	@AfterMethod
	public void finalSetUp() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();
		test.log(Status.INFO, " Browser is closed...");
	}

	@AfterTest
	public void reportsEnd() {
		reports.flush();
	}
}
