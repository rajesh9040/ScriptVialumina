package TestScenarios;

import java.io.IOException;
import org.bson.Document;

import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import Objects.Accounts;
import Objects.Company;
import Objects.Login;
import Objects.Vehicle;
import Objects.VehicleModel;
import Objects.driversManagement;
import utils.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private Login login;
    private Company company;
    private VehicleModel models;
    private driversManagement driverperson;
    // Define other required objects

    private Vehicle transport;
    private Vehicle newVehicle;
    private Vehicle Vnum;
    private Vehicle info;
    private Vehicle tap;
    private Accounts addUsers;
    private driversManagement drivererase;

    String username;

    @BeforeTest
    public void dbConnection() throws InterruptedException, IOException {
        initializeDriver();
        // Initialize other objects here
        System.out.println("setup");

        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://jeevan:yY3fLh4ruuTHRIsr@via-dev-cluster0.kmcn2.mongodb.net/vialumina");
        try (MongoClient mongoClient = new MongoClient(uri)) {
            MongoDatabase database = mongoClient.getDatabase("vialumina");
            MongoCollection<Document> collection = database.getCollection("users");

            // Define your query to retrieve login credentials
            Document query = new Document("phoneNumber", "7008433742");

            // Execute the query and retrieve the results (assuming only one document
            // matches the query)
            MongoCursor<Document> cursor = collection.find(query).iterator();
            if (cursor.hasNext()) {
                // Assuming only one document matches the query, extract the username and
                // password
                Document document = cursor.next();
                username = document.getString("email");
                String password = document.getString("password");
                System.out.println(username);
                System.out.println(password);
            }
        } catch (Exception e) {
            // Handle any exceptions that may occur during MongoDB operations
            e.printStackTrace();
        }
    }

    @Test
    public void loginTest() {
        login = new Login(driver);
        login.enterUserEmail(username);
        login.enterPassword("Kibbcom12");
        login.clickContinue();

    }

    @Test(groups = "organization")
    public void organizationTest() throws InterruptedException {
        company = new Company(driver);
        company.clickOrg();
        Thread.sleep(10000);
    }

    @Test(groups = "vehicleModelsTest", dependsOnGroups = "organization")
    public void vehicleModelsTest() throws InterruptedException {
        models = new VehicleModel(driver);
        Thread.sleep(10000);
        models.clickVehicleModel();
        Thread.sleep(10000);
        models.search("honda");
        Thread.sleep(5000);
        models.grid();
    }

    @Test(groups = "drivers", dependsOnGroups = "organization")
    public void driversTest() throws InterruptedException {
        driverperson = new driversManagement(driver);
        drivererase = new driversManagement(driver);
        Thread.sleep(3000);
        driverperson.clickDriver();
        driverperson.inputDriver();
        driverperson.name("Brian");
        Thread.sleep(5000);
        driverperson.entermail("username@kibbcom2gmail.com");
        driverperson.enternumber("7008433748");
        Thread.sleep(20000);
        driverperson.button();
        Thread.sleep(5000);
        drivererase.deletedriver();
        Thread.sleep(10000);

    }

    @Test(groups = "typesVehicle", dependsOnGroups = "organization")
    public void typesVehicle() throws InterruptedException {
        transport = new Vehicle(driver);
        newVehicle = new Vehicle(driver);
        Vnum = new Vehicle(driver);
        info = new Vehicle(driver);
        tap = new Vehicle(driver);

        transport.clickVehicle();
        newVehicle.AddNewVehicle();
        Vnum.enterVin("WV1ZZZSYZN9005764");
        info.clickInformation();

    }

    @AfterTest
    public void addProject() {
        addUsers = new Accounts(driver);
        addUsers.clickproject();

    }

}
