package org.example;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy (id="first-name")
    private WebElement name;
    @FindBy (id="last-name")
    private WebElement lastName;
    @FindBy (id="postal-code")
    private WebElement postCode;
    @FindBy (id="continue")
    private WebElement btnContinue;
    @FindBy (id="cancel")
    private WebElement btnCancel;
    @FindBy (id="finish")
    private WebElement btnFinish;
    @FindBy(id="cancel")
    private WebElement btnCancelar;
    @FindBy (id="back-to-products")
    private WebElement btnBackHome;

    public void inputName (String nombre){
        this.name.sendKeys(nombre);
    }
    public void inputLastName (String apellido){
        this.lastName.sendKeys(apellido);
    }
    public void inputPostCode (int code){
        String codeAsString = Integer.toString(code);
        this.postCode.sendKeys(codeAsString);
    }
    public void clickBtnContinue(){
        this.btnContinue.click();
    }
    public void clickBtnCancel(){
        this.btnCancel.click();
    }
    public void clickBtnFinish(){
        this.btnFinish.click();
    }
    public void clickBtnCancelar(){
        this.btnCancelar.click();
    }
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
    }
    public void clickBtnBackHome(){
        this.btnBackHome.click();
    }
}
