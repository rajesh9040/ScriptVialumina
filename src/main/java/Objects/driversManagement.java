package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class driversManagement {

    private WebDriver driver;

    public driversManagement(WebDriver driver) {
        this.driver = driver;
    }

    private By driverstab = By.xpath("/html/body/app-dashboard/div/div/div[2]/a[11]/span[2]");

    private By addDriver = By
            .xpath("/html/body/app-dashboard/div/main/div[2]/app-drivers/div[1]/div[2]/div/button/span[1]");
    By driverName = By.id("name");
    By Gmailinput = By.id("emailDriver");
    By mobileNumber = By.id("mobileNumber");
    By tapButton = By.xpath(
            "//div[2]/button");
    By list = By.xpath("//tr[@class='e-row']");
    By driverdelete = By.xpath("//button[@class='newButtonStyle btn-red btn-sm float-right']");
    By warning = By.xpath("//button[@class='btn btn-warning']");

    public void clickDriver() {

        driver.findElement(driverstab).click();
    }

    public void inputDriver() {
        driver.findElement(addDriver).click();
    }

    public void name(String name) {
        driver.findElement(driverName).sendKeys(name);

    }

    public void entermail(String Inputemail) {
        driver.findElement(Gmailinput).sendKeys(Inputemail);
    }

    public void enternumber(String number) {
        driver.findElement(mobileNumber).sendKeys(number);
    }

    public void button() {
        driver.findElement(tapButton).click();
    }

    public void deletedriver() {
        driver.findElement(list).click();
        driver.findElement(driverdelete).click();
        driver.findElement(warning).click();
    }

}
