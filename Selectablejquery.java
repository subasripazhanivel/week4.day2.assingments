package week4.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectablejquery {

	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			ChromeOptions opts=new ChromeOptions();
			opts.addArguments("--disable-notifications");
			ChromeDriver driver = new ChromeDriver(opts);
			driver.get("https://jqueryui.com/selectable/");

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.switchTo().frame(0);
			
			WebElement selectelement1 = driver.findElement(By.xpath("//li[text()='Item 2']"));
			WebElement selectelement2 = driver.findElement(By.xpath("//li[text()='Item 6']"));
			Actions builderSelect=new Actions(driver);
			builderSelect.clickAndHold(selectelement1).moveToElement(selectelement2).release().perform();
			System.out.println("Items selected");
			
			driver.close();		
		}
	}


