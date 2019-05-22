package es.codeurjc.ais.tictactoe;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import io.github.bonigarcia.wdm.WebDriverManager;


public class PruebasSistema {
	
	WebDriver driver1;
	WebDriver driver2;
	WebDriverWait wait1;
	WebDriverWait wait2;
	
	@BeforeClass
	public static void setupClass() {
		//System.setProperty("webdriver.gecko.driver","/absolute/path/to/geckodriver");
		//System.setProperty("webdriver.chrome.driver","/absolute/path/to/chromedriver");
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebApp.start();
	}
	
	@AfterClass
	public static void teardownClass() {
		WebApp.stop();
	}
	
	@Before
	public void setup() {
		driver1 = new ChromeDriver();
		driver2 = new FirefoxDriver();
		wait1 = new WebDriverWait(driver1, 5);
		wait2 = new WebDriverWait(driver2, 5);
	}
	
	@After
	public void teardown() {
		if(driver1 != null) {
			driver1.quit();
		}
		if (driver2 != null) {
			 driver2.quit();
		}
	}
	
	@Test
	public void ganaElX() {
		
		String mensaje = "Paloma wins! Francisco looses.";
		
		//Señalamos la ruta a los drivers
		driver1.get("http://localhost:8080/");
		driver2.get("http://localhost:8080/");
		//Introducimos los nombres de los jugadores
		driver1.findElement(By.id("nickname")).sendKeys("Paloma");
		driver2.findElement(By.id("nickname")).sendKeys("Francisco");
		//Los jugadores le dan al play
		driver1.findElement(By.xpath("//button[@id='startBtn']")).click();
		driver2.findElement(By.xpath("//button[@id='startBtn']")).click();
		//Simulacion del juego
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tr/td[@id='cell-0']")));
		driver1.findElement(By.xpath("//table/tr/td[@id='cell-0']")).click();
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@id='cell-1']")));
		driver2.findElement(By.xpath("//td[@id='cell-1']")).click();
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("cell-3")));
		driver1.findElement(By.id("cell-3")).click();
		wait2.until(ExpectedConditions.elementToBeClickable(By.id("cell-4")));
		driver2.findElement(By.id("cell-4")).click();
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("cell-6")));
		driver1.findElement(By.id("cell-6")).click();
		//Vemos si los mensajes son iguales
		wait1.until(ExpectedConditions.alertIsPresent());
		wait2.until(ExpectedConditions.alertIsPresent());
		String chrome = driver1.switchTo().alert().getText();
		String firefox = driver2.switchTo().alert().getText();
		//System.out.println(chrome);
		//System.out.println(firefox);
		assertThat(chrome).isEqualTo(mensaje);
		assertThat(firefox).isEqualTo(mensaje);
		//assertThat(driver1.switchTo().alert().getText()).isEqualToIgnoringCase(driver2.switchTo().alert().getText());
		
	}
	@Test
	public void ganaElO() {
		
		String mensaje = "Francisco wins! Paloma looses.";
		
		//Señalamos la ruta a los drivers
		driver1.get("http://localhost:8080/");
		driver2.get("http://localhost:8080/");
		//Introducimos los nombres de los jugadores
		driver1.findElement(By.id("nickname")).sendKeys("Paloma");
		driver2.findElement(By.id("nickname")).sendKeys("Francisco");
		//Los jugadores le dan al play
		driver1.findElement(By.xpath("//button[@id='startBtn']")).click();
		driver2.findElement(By.xpath("//button[@id='startBtn']")).click();
		//Simulacion del juego
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tr/td[@id='cell-0']")));
		driver1.findElement(By.xpath("//table/tr/td[@id='cell-0']")).click();
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@id='cell-1']")));
		driver2.findElement(By.xpath("//td[@id='cell-1']")).click();
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("cell-3")));
		driver1.findElement(By.id("cell-3")).click();
		wait2.until(ExpectedConditions.elementToBeClickable(By.id("cell-4")));
		driver2.findElement(By.id("cell-4")).click();
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("cell-2")));
		driver1.findElement(By.id("cell-2")).click();
		wait2.until(ExpectedConditions.elementToBeClickable(By.id("cell-7")));
		driver2.findElement(By.id("cell-7")).click();
		//Vemos si los mensajes son iguales
		wait1.until(ExpectedConditions.alertIsPresent());
		wait2.until(ExpectedConditions.alertIsPresent());
		String chrome = driver1.switchTo().alert().getText();
		String firefox = driver2.switchTo().alert().getText();
		//System.out.println(chrome);
		//System.out.println(firefox);
		assertThat(chrome).isEqualTo(mensaje);
		assertThat(firefox).isEqualTo(mensaje);
		//assertThat(driver1.switchTo().alert().getText()).isEqualToIgnoringCase(driver2.switchTo().alert().getText());
		
	}
	
	@Test
	public void empate() {
		
		String mensaje = "Draw!";
		
		//Señalamos la ruta a los drivers
		driver1.get("http://localhost:8080/");
		driver2.get("http://localhost:8080/");
		//Introducimos los nombres de los jugadores
		driver1.findElement(By.id("nickname")).sendKeys("Paloma");
		driver2.findElement(By.id("nickname")).sendKeys("Francisco");
		//Los jugadores le dan al play
		driver1.findElement(By.xpath("//button[@id='startBtn']")).click();
		driver2.findElement(By.xpath("//button[@id='startBtn']")).click();
		//Simulacion del juego
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tr/td[@id='cell-0']")));
		driver1.findElement(By.xpath("//table/tr/td[@id='cell-0']")).click();
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@id='cell-1']")));
		driver2.findElement(By.xpath("//td[@id='cell-1']")).click();
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("cell-3")));
		driver1.findElement(By.id("cell-3")).click();
		wait2.until(ExpectedConditions.elementToBeClickable(By.id("cell-4")));
		driver2.findElement(By.id("cell-4")).click();
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("cell-7")));
		driver1.findElement(By.id("cell-7")).click();
		wait2.until(ExpectedConditions.elementToBeClickable(By.id("cell-6")));
		driver2.findElement(By.id("cell-6")).click();
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("cell-2")));
		driver1.findElement(By.id("cell-2")).click();
		wait2.until(ExpectedConditions.elementToBeClickable(By.id("cell-5")));
		driver2.findElement(By.id("cell-5")).click();
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("cell-8")));
		driver1.findElement(By.id("cell-8")).click();
		//Vemos si los mensajes son iguales
		wait1.until(ExpectedConditions.alertIsPresent());
		wait2.until(ExpectedConditions.alertIsPresent());
		String chrome = driver1.switchTo().alert().getText();
		String firefox = driver2.switchTo().alert().getText();
		//System.out.println(chrome);
		//System.out.println(firefox);
		assertThat(chrome).isEqualTo(mensaje);
		assertThat(firefox).isEqualTo(mensaje);
		//assertThat(driver1.switchTo().alert().getText()).isEqualToIgnoringCase(driver2.switchTo().alert().getText());
		
	}
	
}
