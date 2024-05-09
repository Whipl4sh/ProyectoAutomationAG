package org.example;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {
    @FindBy(css = "button.btn")
    private List<WebElement> btnsAddCart;
    @FindBy(className = "btn_secondary")
    private List<WebElement> btnsRemoveCart;
    @FindBy(id = "shopping_cart_container")
    private WebElement logoCarrito;


    @FindBy(css = "span.shopping_cart_badge")
    private WebElement itemAdd;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void añadirACarro(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Espera máximo 10 segundos
        WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(btnsAddCart.get(index)));
        boton.click();
    }

    public void eliminarACarro(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Espera máximo 10 segundos
        WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(btnsRemoveCart.get(index)));
        boton.click();
    }

    public void clickCarrito() {
        this.logoCarrito.click();
    }

    public void verifyItemAdd() {
        if (this.itemAdd.isDisplayed()) {
            System.out.println("Se ha añadido el producto");
        }

        }
    public boolean  verifyRemoveItem () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOf(this.itemAdd));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    }



