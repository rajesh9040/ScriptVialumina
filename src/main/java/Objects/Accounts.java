package Objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Accounts {

    private WebDriver driver;

    public Accounts(WebDriver driver) {

        this.driver = driver;
    }

    private By clickAccount = By.xpath("//a[@href='#project']");
    private By addAccount = By.xpath("//span[text()='Add Account']");
    private By addName = By.id("name");
    private By customerName = By.id("customer");
    private By daterange = By.xpath("//span[@class='e-input-group-icon e-range-icon e-icons']");

    private By submit = By.xpath("//button[@class='newButtonStyle btn-green']");

    public void clickproject() {
        driver.findElement(clickAccount).click();
    }

    public void addproject() {
        driver.findElement(addAccount).click();
    }

    public void name(String title) {
        driver.findElement(addName).sendKeys(title);
    }

    public void customer(String guest) {
        driver.findElement(customerName).sendKeys(guest);
    }

}
