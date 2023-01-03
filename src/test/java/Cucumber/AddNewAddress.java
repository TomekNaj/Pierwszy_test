package Cucumber;

import POP.AddAddress;
import POP.LoginAs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AddNewAddress {

    private WebDriver driver;

    @Given("register user fill in New Address at {string} website")
    public void registerUserFillInNewAddressAtWebsite(String websiteURL) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(websiteURL);
        driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span")).click();

    }

    @And("user is logged in with email {string} and password {string}")
    public void userIsLoggedInWithEmailEmailAndPasswordPassword(String email, String password) {
        LoginAs loginAs = new LoginAs(driver);
        loginAs.LoginUser(email, password);
    }

    @When("user clicked at Add Address buttom")
    public void userClickedAtAddAddressButtom() {
        WebElement addAddressButton = driver.findElement(By.xpath("//*[@id=\"footer_account_list\"]/li[4]/a"));
        addAddressButton.click();
        WebElement createNewAddressButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a/span"));
        createNewAddressButton.click();

    }

    @And("user fill in alias {string}, address {string}, city {string}, post code {string}, country {string}, phone {string}")
    public void userFillInAliasAliasAddressAddressCityCityPostCodePostCodeCountryCountryPhonePhone(String alias, String address, String city, String postCode, String country, String phone) {
        AddAddress addAddress = new AddAddress(driver);
        addAddress.NewAddressAdd(alias, address, city, postCode, country, phone);
    }

    @Then("new address is data is correct and contains {string}, {string}, {string}, {string}, {string}, {string}")
    public void newAddressIsDataIsCorrectAndContainsAliasAddressCityPostCodeCountryPhone(String alias, String address, String city, String postCode, String country, String phone) {
        WebElement updateAddressButton = driver.findElement(By.xpath("//*[@id=\"address-30009\"]/div[2]/a[1]/span"));
        updateAddressButton.click();
        String CheckAlias = driver.findElement(By.id("field-alias")).getText();
        Assertions.assertEquals(CheckAlias, alias);
    }

}
