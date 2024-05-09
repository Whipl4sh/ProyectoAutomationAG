import org.example.CarroDeCompras;
import org.example.HomePage;
import org.example.inicioSesionPom;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//UN escenario donde se agregan 3 productos y se va al carrito de compra y se eliminan desde ahi
public class Escenario03 {
    private static WebDriver driver;
    inicioSesionPom isp;
    HomePage hp;
    @BeforeAll
    public static void antesTest() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Agust\\OneDrive\\Escritorio\\Herramientas de Automatizacion\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
    //Inicio se de sesion normal
    @Test
    public void tc01(){
        inicioSesionPom isp= new inicioSesionPom(driver);
        isp.inputUsers("standard_user");
        isp.inputPassword("secret_sauce");
        isp.clickBtnSubmit();
    }
    //Se agregan los productos
    @Test
    public void tc02(){
        HomePage hp= new HomePage(driver);
        hp.añadirACarro(0);
        hp.añadirACarro(1);
        hp.añadirACarro(2);
        hp.verifyItemAdd();
    }
    //Se redirige a carro de compras
    @Test
    public void tc03(){
        HomePage hp= new HomePage(driver);
        hp.clickCarrito();
    }
    @Test
    public void tc04(){
        CarroDeCompras cdc= new CarroDeCompras(driver);
        cdc.removeItem(2);
        cdc.verifyItemRemove(2);//EL index sirve para indicar cual index se elmino

    }
    //verifica que el logo del carrito de compras no sea clickeable
    @Test
    public void tc05(){
        CarroDeCompras cdc= new CarroDeCompras(driver);
        cdc.verifyClickLogoCarrito(false);//Indicar Flse si se espera que no pueda ser selecionado si no True
    }
    //Probar el boton de volver a tienda y volver para ver si se quedan los productos guardados
    @Test
    public void tc06(){
        CarroDeCompras cdc= new CarroDeCompras(driver);
        cdc.clickContinueShopping();
        driver.navigate().back();
    }
    //Probar el boton de checkout
    @Test
    public void tc07(){
        CarroDeCompras cdc= new CarroDeCompras(driver);
        cdc.clickCheckout();
    }
    @AfterAll
    public static void finalTest (){
        //driver.quit();

    }

}
