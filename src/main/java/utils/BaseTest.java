package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;

    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream(
                "C:\\Users\\91700\\eclipse-workspace\\Vialuminaa\\src\\main\\java\\Constant\\Global.Property");
        prop.load(file);
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        // Add support for other browsers if needed

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://stage.app.vialumina.eu/#/login");
        return driver;
    }

    // Add other common methods if required

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
