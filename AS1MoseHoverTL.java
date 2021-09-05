package week4.day2.assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AS1MoseHoverTL {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		ChromeOptions optns=new ChromeOptions();
		optns.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(optns);
		driver.get("http://www.leafground.com/pages/mouseOver.html");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement mouseHoverCourse = driver.findElement(By.linkText("TestLeaf Courses"));
		Actions builderMH=new Actions(driver);
		builderMH.moveToElement(mouseHoverCourse).perform();
		
		System.out.println("Course Details :");
		List<WebElement> courseDetials=driver.findElements(By.className("listener"));
		for(int i=0;i<courseDetials.size();i++) {
			String courseList=courseDetials.get(i).getText();
			System.out.println(courseList);
		}
			driver.findElement(By.linkText("Selenium")).click();
			Alert alrt1=driver.switchTo().alert();
			alrt1.accept();
			System.out.println("\n........Alert dismissed................");
			
			driver.quit();
		}
			
		}
	


