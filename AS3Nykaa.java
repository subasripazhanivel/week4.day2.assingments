package week4.day2.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AS3Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions optns=new ChromeOptions();
		optns.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(optns);

		// 1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");

		// Maximizing browser window
		driver.manage().window().maximize();

		// Wait Management

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());

		// Mouseover on Brands and Mouseover on Popular
		Thread.sleep(2000);
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		WebElement brndPopular = driver.findElement(By.xpath("//a[text()='Popular']"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(brand).moveToElement(brndPopular).perform();
		
		Thread.sleep(2000);
		// Click L'Oreal Paris
	driver.findElement(By.xpath("//*[@id=\"brandCont_Popular\"]/ul/li[5]/a")).click();
		
				
		

		// Go to the newly opened window and check the title contains L'Oreal Paris
		
		  Set<String> windowhandleSet1= driver.getWindowHandles(); List<String>
		  windowhandlesList1=new ArrayList<String>(windowhandleSet1); WebDriver
		  lorealDriver= driver.switchTo().window(windowhandlesList1.get(1));
		 
		String title = "L'Oreal Paris - Buy L'Oreal Paris Products Online at Best Price | Nykaa";
		System.out.println(title);
		if (lorealDriver.getTitle().equals(title)) {
			System.out.println("L'oreal paris window loaded");
		} else {
			System.out.println("L'oreal paris window is not loaded");
		}

		Thread.sleep(2000);
		// Click sort By and select customer top rated
		driver.findElement(By.xpath("//div[@class='sort-btn clearfix']")).click();

		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();

		Thread.sleep(2000);
		// Click Category and click Shampoo
		    driver.findElement(By.xpath("//div[text()='Category']")).click();
			driver.findElement(By.xpath("//span[text()='Hair']")).click();
			driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
			driver.findElement(By.xpath("//span[text()='Shampoo']")).click();

			/*
			 * Actions builderPageUp=new Actions(driver);
			 * builderPageUp.sendKeys(Keys.PAGE_UP).perform(); Thread.sleep(2000);
			 */
		 
		// check whether the Filter is applied with Shampoo
		String filter = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']/li")).getText();
		if (filter.contains("Shampoo")) {
			System.out.println("Filter is applied for shampoo");
		} else {
			System.out.println("Filter is not applied for shampoo");
		}

		// Click on L'Oreal Paris Colour Protect Shampoo
		List<WebElement> productList = driver.findElements(By.xpath("//div[@class='m-content__product-list__title']"));
		for (WebElement product : productList) {
			if (product.getText().contains("L'Oreal Paris Colour Protect Shampoo")) {
				product.click();
				break;
			}
		}
		Thread.sleep(1000);
		// GO to the new window and select size as 175ml
		Set<String> windowhandleSet2 = driver.getWindowHandles();
		List<String> windowhandlesList2 = new ArrayList<String>(windowhandleSet2);
		driver.switchTo().window(windowhandlesList2.get(2));
		driver.findElement(
				By.xpath("//div[@class='options-sizes-lists-wrap horizontalScoll --alter pull-left']//li[1]")).click();
		Thread.sleep(1000);
		// Print the MRP of the product
		String mrp = driver.findElement(By.xpath("//span[@class='post-card__content-price-offer']")).getText();
		System.out.println("MRP: " + mrp);

		// Click on ADD to BAG
		driver.findElement(By.xpath("//div[@class='pull-left']//button")).click();

		// Go to Shopping Bag

		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		Thread.sleep(2000);
		// Print the Grand Total amount
		String grandTotal = driver.findElement(By.xpath("//div[@class='first-col']/div")).getText();
		System.out.println("Total Amount: " + grandTotal);
		Thread.sleep(2000);
		// Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		Thread.sleep(1000);
		// Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();

		//Check if this grand total is the same in step 13

		String finalTotal = driver.findElement(By.xpath("(//div[@class='value']/span)[2]")).getText();
		System.out.println("Final Total amount:"+finalTotal);
		if (grandTotal.equals(finalTotal)) {
			System.out.println("Total amount is same as in add bag list");
		} else {
			System.out.println("Total amount is not same as in add bag list");
		}

	}

}
