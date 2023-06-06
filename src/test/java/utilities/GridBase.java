package utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GridBase {

    DesiredCapabilities  cap =new DesiredCapabilities();

    public static String hubUrl="http://192.168.0.32:4444";

    public static String browser="chrome";


    public WebDriver setDriver(WebDriver driver) {

        if (browser=="chrome"){

            cap.setPlatform(Platform.ANY);
            cap.setBrowserName("chrome");
            //  cap.setVersion("111.0.5563.147");

            ChromeOptions options= new ChromeOptions();
            options.merge(cap);

        }
        if(browser=="IE"){

            cap.setPlatform(Platform.ANY);
            cap.setBrowserName("IE");
            // cap.setVersion("111.0.1661.54");

            InternetExplorerOptions ieoptions=new InternetExplorerOptions();
            ieoptions.merge(cap);

        }
        if(browser=="Firefox"){

            cap.setPlatform(Platform.ANY);
            cap.setBrowserName("Firefox");
            // cap.setVersion("111.0.1661.54");

            FirefoxOptions firefoxoptions=new FirefoxOptions();
            firefoxoptions.merge(cap);

        }

        try {
            driver =  new RemoteWebDriver(new URL(hubUrl),cap);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   driver.manage().window().maximize();

        return  driver;

    }
}