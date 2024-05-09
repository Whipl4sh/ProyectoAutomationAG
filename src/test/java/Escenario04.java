import org.example.CarroDeCompras;
import org.example.CheckoutPage;
import org.example.HomePage;
import org.example.inicioSesionPom;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Escenario04 {
    private static WebDriver driver;
    inicioSesionPom isp;
    HomePage hp;
    CheckoutPage cp;
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
    //Ir al carro de compras
    @Test
    public void tc03(){
        HomePage hp= new HomePage(driver);
        hp.clickCarrito();
    }
    //boton de checkout
    @Test
    public void tc04(){
        CarroDeCompras cdc= new CarroDeCompras(driver);
        cdc.clickCheckout();
    }
    //Salir del checkout y volver a entrar para probar si se guarda la informacion
    @Test
    public void tc05(){
        CheckoutPage cp= new CheckoutPage(driver);
        cp.inputName("Agustin12");
        cp.inputLastName("Gialo34@");
        cp.inputPostCode(123);
        cp.clickBtnCancel();
        driver.navigate().back();
    }
    //Modifico los campos con nueva informacion y sigo a la proxima pantalla
    @Test
    public void tc06(){
        CheckoutPage cp= new CheckoutPage(driver);
        cp.inputName("Agustin");
        cp.inputLastName("Gialo");
        cp.inputPostCode(1232);
        cp.clickBtnContinue();

    }
    //Salir y volver a entrar en la pantalla final de compra
    @Test
    public void tc07(){
        CheckoutPage cp= new CheckoutPage(driver);
        cp.scrollDown();
        cp.clickBtnCancel();
        driver.navigate().back();
    }
    //Completar el proceso de checkout
    @Test
    public void tc08(){
        CheckoutPage cp= new CheckoutPage(driver);
        cp.scrollDown();
        cp.clickBtnFinish();
    }
    @Test
    public void tc09(){
        CheckoutPage cp= new CheckoutPage(driver);
        cp.clickBtnBackHome();
    }

    @AfterAll
    public static void finalTest (){
        driver.quit();

    }
}
