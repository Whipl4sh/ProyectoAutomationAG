import org.example.HomePage;
import org.example.inicioSesionPom;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Escenario02 {
    private static WebDriver driver;
    HomePage hp;
    @BeforeEach
    public  void antesTest() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Agust\\OneDrive\\Escritorio\\Herramientas de Automatizacion\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.manage().window().maximize();
    }
    @Test
    public void tc01(){
       HomePage hp= new HomePage(driver);
       hp.añadirACarro(1);
    }
    //Inicio se de sesion fallando el usuario
    @Test
    public void tc04(){
        inicioSesionPom isp= new inicioSesionPom(driver);
        isp.inputUsers("visual_user");
        isp.inputPassword("secret_sauce");
        isp.clickBtnSubmit();
        Assertions.assertNotEquals(driver.findElement(By.cssSelector("img[src=\"/static/media/sl-404.168b1cce.jpg\"]")),driver.findElement(By.cssSelector("img[src=\"/static/media/bike-light-1200x1500.37c843b0.jpg\"]")));
    }
    @Test
    public void tc03(){
        inicioSesionPom isp= new inicioSesionPom(driver);
        isp.inputUsers("problem_user");
        isp.inputPassword("secret_sauce");
        isp.clickBtnSubmit();
        Assertions.assertTrue(driver.findElement(By.cssSelector("img[src=\"/static/media/sl-404.168b1cce.jpg\"]")).isDisplayed());//Imagenes repetidas
    }
    //Inicio se de sesion fallando el usuario
    @Test
    public void tc02(){
        inicioSesionPom isp= new inicioSesionPom(driver);
        isp.inputUsers("locked_out_user");
        isp.inputPassword("secret_sauce");
        isp.clickBtnSubmit();
        Assertions.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());//El cartel de error
    }
    @AfterEach
    public void finalTest (){
       // driver.quit();

    }
}
