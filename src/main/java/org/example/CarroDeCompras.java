package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarroDeCompras extends BasePage{
    @FindBy (css ="button.btn.btn_secondary[data-test^='remove-']")
    private List<WebElement> btnsRemove;
    @FindBy (css="a.shopping_cart_link")
    private WebElement logoCarrito;
    @FindBy (id="continue-shopping")
    private WebElement btnContinueShopping;
    @FindBy (id="checkout")
    private WebElement btnCheckout;

    public CarroDeCompras(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void removeItem (int index){
        this.btnsRemove.get(index).click();

    }
    public boolean verifyItemRemove (int index){
        int cantidadBotones = btnsRemove.size();
        if (cantidadBotones <= 2) {
            System.out.println("Se eliminó el producto del Carro de compra.");
            return true;
        } else {
            System.out.println("Aún hay más de 2 productos en el carrito.");
            return false;
        }
    }
    public void verifyClickLogoCarrito(boolean notClick){
        if ( this.logoCarrito.isSelected()){
            System.out.println("Este objeto es clickeable");
        } else {
            System.out.println("Este logo no es clickeable");

        }
    }
    public void clickCheckout(){
        this.btnCheckout.click();
    }
    public void clickContinueShopping(){
        this.btnContinueShopping.click();
    }
    }

