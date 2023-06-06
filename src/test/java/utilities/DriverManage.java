package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManage { //proje içerisine eklediğim  browser driverlarının  yollarını göstermem gerekli

    public static WebDriver driver;

    public static void setDriver(String browser) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
        System.setProperty("webdriver.msedge.driver", "src/test/resources/drivers/msedgedriver");

        switch (browser) {
            case "grid_firefox": {
                // FirefoxOptions firefoxOptions = new FirefoxOptions();
                // firefoxOptions.addArguments("start-maximized");
                try {
                    driver = new RemoteWebDriver(new URL("http://192.168.0.32:4444"), new FirefoxOptions());
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("°°°°° Selenium Grid Firefox °°°°°°");
                break;
            }
            case "grid_chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                try {
                    driver = new RemoteWebDriver(new URL("http://192.168.0.32:4444"),  new ChromeOptions());
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("°°°°° Selenium Grid Chrome °°°°°°");
                break;
            }
            case "grid_edge": {
                EdgeOptions edgeOptions = new EdgeOptions();
                //edgeOptions.addArguments("start-maximized");
                try {
                    driver = new RemoteWebDriver(new URL("http://192.168.0.32:4444"), new  EdgeOptions () );
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("°°°°° Selenium Grid Edge °°°°°°");
                break;
            }
            case "grid_IE": {
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                // ieOptions.addArguments("start-maximized");
                try {
                    driver = new RemoteWebDriver(new URL("http://192.168.0.32:4444"), ieOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("°°°°° Selenium Grid IE °°°°°°");
                break;
            }
            case "chrome": {
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--remote-allow-origins=*");
                ops.addArguments("start-maximized");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(ops);
                break;
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            }
            case "IE": {
                WebDriverManager.iedriver().setup();
                driver = new EdgeDriver();
                break;
            }
            default: {
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--remote-allow-origins=*");
                ops.addArguments("start-maximized");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(ops);
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }


}
