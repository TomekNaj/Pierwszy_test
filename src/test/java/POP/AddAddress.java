package POP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAddress {

    private WebDriver driver;

    @FindBy(id = "field-alias")
    private WebElement aliasInput;

    @FindBy(id = "field-address1")
    private WebElement addressInput;

    @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(id = "field-postcode")
    private WebElement postCodeInput;

    @FindBy(id = "field-id_country")
    private WebElement countrySelect;

    @FindBy(id = "field-phone")
    private WebElement phoneInput;

    @FindBy(xpath= "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement saveButtonSelect;

    public AddAddress (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void NewAddressAdd(String alias, String address, String city, String postCode, String country, String phone) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);
        addressInput.clear();
        addressInput.sendKeys(address);
        cityInput.clear();
        cityInput.sendKeys(city);
        postCodeInput.clear();
        postCodeInput.sendKeys(postCode);
        countrySelect.sendKeys(country);
        phoneInput.clear();
        phoneInput.sendKeys(phone);
        saveButtonSelect.click();
    }
}
