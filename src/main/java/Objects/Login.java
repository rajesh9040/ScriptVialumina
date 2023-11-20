package Objects;

import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Login {

    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    private By userEmailInput = By.xpath("/html/body/app-dashboard/div/main/div[2]/div/div/form/div[2]/input");
    private By passwordInput = By.xpath("/html/body/app-dashboard/div/main/div[2]/div/div/form/div[3]/input");
    private By continueButton = By.xpath("/html/body/app-dashboard/div/main/div[2]/div/div/form/button");

    public void enterUserEmail(String email) {
        driver.findElement(userEmailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

}
