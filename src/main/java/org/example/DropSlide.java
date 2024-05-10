package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropSlide extends BasePage{
    public DropSlide(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy (id="react-burger-menu-btn")
    private WebElement btnDropSlide;

    public WebElement getBtnAllItems() {
        return btnAllItems;
    }

    public void setBtnAllItems(WebElement btnAllItems) {
        this.btnAllItems = btnAllItems;
    }

    @FindBy (id="inventory_sidebar_link")
    private WebElement btnAllItems;
    @FindBy (id="about_sidebar_link")
    private WebElement btnAbout;
    @FindBy (id="logout_sidebar_link")
    private WebElement bntLogOut;

    public WebElement getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(WebElement btnReset) {
        this.btnReset = btnReset;
    }

    @FindBy (id="reset_sidebar_link")
    private WebElement btnReset;

    public void clickDropSlide(){
      this.btnDropSlide.click();
    }
    public void clickAllItems(){
        this.btnAllItems.click();
    }

    public WebElement getBtnAbout() {
        return btnAbout;
    }

    public void setBtnAbout(WebElement btnAbout) {
        this.btnAbout = btnAbout;
    }

    public void clickAbout (){
        this.btnAbout.click();
    }
    public void clickLogOut(){
        this.bntLogOut.click();
    }
    public void clickReset(){
        this.btnReset.click();
    }
    public void esperar(WebElement btn){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementoClickeable =
                wait.until(ExpectedConditions.elementToBeClickable(btn));
    }

}
