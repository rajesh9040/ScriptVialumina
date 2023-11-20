package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Company {

    private WebDriver driver;

    public Company(WebDriver driver) {
        this.driver = driver;
    }

    private By orgInput = By.xpath("//div[1]/div[2]/button/span");

    public void clickOrg() {
        driver.findElement(orgInput).click();
    }
}
