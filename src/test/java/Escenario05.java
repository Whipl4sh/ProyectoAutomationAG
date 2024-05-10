import org.example.DropSlide;
import org.example.inicioSesionPom;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//En este escenario se va a probar todos los botones de DropSlide
public class Escenario05 {
    private static WebDriver driver;
    inicioSesionPom isp;
    DropSlide dp;

    @BeforeEach
    public   void antesTest() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Agust\\OneDrive\\Escritorio\\Herramientas de Automatizacion\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.manage().window().maximize();
        inicioSesionPom isp= new inicioSesionPom(driver);
        isp.inputUsers("standard_user");
        isp.inputPassword("secret_sauce");
        isp.clickBtnSubmit();
    }
    //PROBAR EL BOTON LOGOUT
    @Test
    public void tc01(){
        DropSlide dp= new DropSlide(driver);
        dp.clickDropSlide();
        dp.clickLogOut();
    }
    //Probar el boton About
    @Test
    public void tc02(){
        DropSlide dp= new DropSlide(driver);
        dp.clickDropSlide();
        dp.esperar(dp.getBtnAbout());
        dp.clickAbout();
    }
    //Probar el boton reset
    @Test
    public void tc03(){
        DropSlide dp= new DropSlide(driver);
        dp.clickDropSlide();
        dp.esperar(dp.getBtnReset());
        dp.clickReset();
    }
    //Probar el boton todos los items
    @Test
    public void tc04(){
        DropSlide dp= new DropSlide(driver);
        dp.clickDropSlide();
        dp.esperar(dp.getBtnAllItems());
        dp.clickAllItems();
    }

    @AfterEach
    public   void finalTest (){
       //driver.quit();

    }
}
