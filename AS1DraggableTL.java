package week4.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AS1DraggableTL {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions optns=new ChromeOptions();
		optns.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(optns);
		driver.get("http://www.leafground.com/pages/drag.html");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		Actions builderDrag=new Actions(driver);
		builderDrag.dragAndDropBy(drag, 80,100).perform();
		
		driver.close();
		
		
	}

}
