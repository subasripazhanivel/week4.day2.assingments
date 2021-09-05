package week4.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AS1DropTL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions optns=new ChromeOptions();
		optns.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(optns);
		driver.get("http://www.leafground.com/pages/drop.html");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions builderDragDrop=new Actions(driver);
		builderDragDrop.dragAndDrop(drag, drop).perform();
		System.out.println("Element dropped in the given position");
		driver.close();
		
	}

}
