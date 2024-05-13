
import org.example.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Escenario06 {
    private static WebDriver driver;
    inicioSesionPom isp;
    DropSlide dp;
    CheckoutPage cp;
    HomePage hp;
    CarroDeCompras cdp;
    //En estos escenarios va a ser variados
    @BeforeEach
    public   void antesTest() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Agust\\OneDrive\\Escritorio\\Herramientas de Automatizacion\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        inicioSesionPom isp= new inicioSesionPom(driver);
        isp.inputUsers("standard_user");
        isp.inputPassword("secret_sauce");
        isp.clickBtnSubmit();
    }
    //Pruebas de todas las  funcionales
    @Test
    public void tc01(){
        HomePage hp= new HomePage(driver);
        CheckoutPage cp= new CheckoutPage(driver);
        CarroDeCompras cdp= new CarroDeCompras(driver);
        //Se añade los productos desde la pagina principal
        hp.añadirACarro(0);
        hp.añadirACarro(1);
        hp.añadirACarro(2);
        //Se elimina los productos desde la pagina
        hp.eliminarACarro(1);
        //Se redirige al carrito de compra
        hp.clickCarrito();
        //Se remueve un producto desde el carro de compra
        cdp.removeItem(0);
        //vuelve a la pagina principal
        cdp.clickContinueShopping();
        //Se agrega otro producto
        hp.añadirACarro(3);
        //Vuelve al carro de compra
        hp.clickCarrito();
        //Se dirige al checkout
        cdp.clickCheckout();
        //Introduce los datos
        cp.inputName("Agustin");
        cp.inputLastName("Gonzalez");
        cp.inputPostCode(9420);
        cp.clickBtnContinue();
        //Se termina la compra
        cp.clickBtnFinish();
        //Se vuelve a la pagina principal
        cp.clickBtnBackHome();
    }
    @Test
    public void tc02(){

    }



    @AfterEach
    public   void finalTest (){
        //driver.quit();

    }
}

