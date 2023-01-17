package Cucumber;
import POP.LoginAs;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.netty.handler.codec.http.multipart.FileUpload;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BuyNewProduct {
    private WebDriver driver;

        @Given("user go on website {string}")
        public void userGoOnWebsite(String websiteURL) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(websiteURL);
            driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span")).click();
        }

        @And("logged in with email {string} and password {string}")
        public void loggedInWithEmailAndPassword(String email, String password){
            LoginAs loginAs = new LoginAs(driver);
            loginAs.LoginUser(email, password);
        }

        @When("user choose product {string}")
        public void UserChooseProduct(String productName){
            WebElement searchField = driver.findElement(By.xpath("//*[@id=\"search_widget\"]/form/input[2]"));
            searchField.sendKeys(productName);
            searchField.submit();
            WebElement chooseProduct = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a/img"));
            chooseProduct.click();
        }

        @And("user choose size {string}")
        public void userChooseSize(String size) {
        WebElement sizeMElement = driver.findElement(By.xpath("//*[@id=\"group_1\"]"));
        sizeMElement.sendKeys(size);
        sizeMElement.click();
    }

        @And("user add five pieces")
        public void UserAddFivePieces(){
        driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE),"5");
        }

        @And("user cliked add product")
        public void UserClikedAddProduct(){
            WebElement addToCard = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));
            addToCard.click();
            WebElement proceedToCheckout = driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
            proceedToCheckout.click();
                }

        @And("user confirmed address to send")
        public void userConfirmedAddressToSend(){
            WebElement proceedButtom = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div"));
            proceedButtom.click();
            WebElement checkOutAddressesButtom = driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button"));
            checkOutAddressesButtom.click();
        }

        @And("choose pick up and payment method")
        public void choosePickUpAndPaymentMethod(){
            WebElement pretaShopmetod = driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/div/div[1]/div[1]/div/span/span"));
            pretaShopmetod.click();
            WebElement shippingMethodButtom = driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button"));
            shippingMethodButtom.click();
            WebElement paymentClik = driver.findElement(By.xpath("//*[@id=\"payment-option-1\"]"));
            paymentClik.click();
        }

        @Then("cliked to order with an obligation to pay")
        public void clikedToOrderWithAnObligationToPay(){
            WebElement agreeTerms = driver.findElement(By.xpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]"));
            agreeTerms.click();
        }

        @And("make screenshoot with order confirmation and amount")
        public void makeScreenschootWithOrderConfirmationAndAmount( ) throws IOException {
            File shot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(shot, new File("C:\\Users\\Tomasz\\CodersLab\\Zaliczenie1\\shot1.jpg"));

        }


}
