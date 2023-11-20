package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class VehicleModel {

    private WebDriver driver;

    public VehicleModel(WebDriver driver) {
        this.driver = driver;
    }

    private By model = By.xpath("/html/body/app-dashboard/div/div/div[2]/a[3]/span[2]");
    private By searchBox = By.xpath(
            "/html/body/app-dashboard/div/main/div[2]/app-vehiclemodels/div[1]/div[2]/div/div[1]/span/ng-select/div/div/div[2]/input");
    By gridmode = By
            .xpath("/html/body/app-dashboard/div/main/div[2]/app-vehiclemodels/div[1]/div[2]/div/div[2]/div/span[2]");

    public void clickVehicleModel() {
        driver.findElement(model).click();
    }

    public void search(String brand) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.sendKeys(brand);

        Actions actions = new Actions(driver);
        actions.sendKeys(searchInput, Keys.ENTER);
        actions.build().perform();

    }

    public void grid() {
        driver.findElement(gridmode).click();
    }

}
