package POP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAs {
    private WebDriver driver;

    @FindBy(id = "field-email")
    private WebElement emailInput;

    @FindBy(id = "field-password")
    private WebElement passwordInput;

    @FindBy(id = "submit-login")
    private WebElement registerButtonSelect;

    public LoginAs (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void LoginUser(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        registerButtonSelect.click();
    }
}
