package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroPage {
    public ZeroPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "signin_button")
    public WebElement signInLink;

    @FindBy(id = "user_login")
    public WebElement usernameBox;

    @FindBy(id = "user_password")
    public WebElement passwordBox;

    @FindBy(name = "submit")
    public WebElement signInButton;

    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBankingLink;

    @FindBy(id ="pay_bills_link")
    public WebElement payBillsLink;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignCurrencyLink;

    @FindBy(id = "pc_currency")
    public WebElement pcCurrencyDropdownElement;
}
