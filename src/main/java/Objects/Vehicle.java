package Objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vehicle {

	private WebDriver driver;

	public Vehicle(WebDriver driver) {
		this.driver = driver;
	}

	private By typesVehicle = By.xpath("//a[@href='#/vehicles']");
	private By AddVehicle = By.xpath("//div/button/span[1]");
	private By VinNum = By.id("vinNumber");
	private By getInfo = By.xpath(
			"/html/body/app-dashboard/div/main/div[2]/app-vehicles/div[4]/div/div/div/app-add-vehicle/div[1]/div[2]/form/div[1]/div[2]/form/div/button");
	private By submit = By.xpath(
			"/html/body/app-dashboard/div/main/div[2]/app-vehicles/div[4]/div/div/div/app-add-vehicle/div[1]/div[2]/form/div[3]/button");
	private By vehicleselect = By.xpath("//tr[@class='e-row']");
	private By deletevehicle = By.xpath("//button[@class='newButtonStyle btn-red btn-sm float-right']");
	private By confirm = By.xpath("//button[@class='btn btn-warning']");

	public void clickVehicle() {
		driver.findElement(typesVehicle).click();

	}

	public void AddNewVehicle() throws InterruptedException {
		driver.findElement(AddVehicle).click();
		Thread.sleep(9000);
	}

	public void enterVin(String newVin) {
		driver.findElement(VinNum).sendKeys(newVin);
	}

	public void clickInformation() throws InterruptedException {
		driver.findElement(getInfo).click();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		// Javascript executor
		Actions at = new Actions(driver);
		at.sendKeys(Keys.PAGE_DOWN).build().perform();

		Thread.sleep(15000);

		driver.findElement(submit).click();

		Thread.sleep(5000);

		driver.findElement(vehicleselect).click();

		Thread.sleep(5000);
		driver.findElement(deletevehicle).click();
		Thread.sleep(2000);
		driver.findElement(confirm).click();
		System.out.println("Successfull deleted");
	}

}
