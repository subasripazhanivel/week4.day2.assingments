package week4.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class As1Sortable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement selectelement1 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement selectelement2 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		Thread.sleep(2000);
		Point loc=selectelement2.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		//System.out.println(x);
		//System.out.println(y);
		Thread.sleep(2000);
		Actions buildersort=new Actions(driver);
		buildersort.dragAndDropBy(selectelement1, x, y).perform();
		System.out.println("Sorted");
		
	}

}
