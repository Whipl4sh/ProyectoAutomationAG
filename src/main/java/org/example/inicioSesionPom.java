package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class inicioSesionPom extends BasePage {
    @FindBy(id="user-name")
    private WebElement users;
    @FindBy(id="password")
    private WebElement password;
    @FindBy(id="login-button")
    private WebElement btnSubmit;

    public inicioSesionPom(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void clickBtnSubmit(){
      this.btnSubmit.click();
    }
    public void inputUsers(String usuario){
        this.users.sendKeys(usuario);
    }
    public void inputPassword(String contraseña){
        this.password.sendKeys(contraseña);
    }



}
