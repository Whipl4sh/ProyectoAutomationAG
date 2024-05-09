

import org.example.HomePage;
import org.example.inicioSesionPom;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Se describe un escenario de sesion exitoso y agregar un producto al carro de compra
public class Escenario01 {
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
   //Se añade un item y se verifica en el carrito que se añadio
   @Test
   public void tc02(){
      HomePage hp= new HomePage(driver);
      hp.añadirACarro(0);
      hp.añadirACarro(1);
      hp.añadirACarro(2);
      hp.verifyItemAdd();
   }
   //Se elimina el producto y se verificar que no haya producto
   @Test
   public void tc03(){
      HomePage hp= new HomePage(driver);
      hp.eliminarACarro(2);// Si son varios botones empezar el index de arriba para abajo
      hp.eliminarACarro(1);
      if (hp.verifyRemoveItem() ) {
         // La eliminación fue exitosa
         System.out.println("El producto ha sido removido correctamente.");
      } else {
         // La eliminación no fue exitosa
         System.out.println("El producto no se ha removido correctamente o aún está presente.");
      }
   }


   @AfterAll
   public static void finalTest (){
      //driver.quit();

   }
}
