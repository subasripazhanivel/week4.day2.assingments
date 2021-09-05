package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class As4SanpDeal {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions optns=new ChromeOptions();
		optns.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(optns);
		
		//1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");

		// Maximizing browser window
		driver.manage().window().maximize();

		// Wait Management

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
		
		//2. Go to Mens Fashion
		WebElement menhover = driver.findElement(By.linkText("Men's Fashion"));
		Actions builder=new Actions(driver);
		builder.moveToElement(menhover).perform();
		
		//3. Go to Sports Shoes
		driver.findElement(By.linkText("Sports Shoes")).click();
		
		//4. Get the count of the sports shoes
		String shoeCount = driver.findElement(By.xpath("//h1[@class='category-name']/span")).getText();
		String replaceTotal = shoeCount.replaceAll("[^0-9]", "");
		int count = Integer.parseInt(replaceTotal);
		System.out.println("Total sports shoes count: " + count);
					
		//5. Click Training shoes
		driver.findElement(By.xpath("//div[@class='child-cat-name '][text()='Training Shoes']")).click();
		
		//6. Sort by Low to High
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[@data-sorttype='plth']")).click();
		Thread.sleep(3000);
		
		//To load all items 
	Actions builderScroll=new Actions(driver);
		builderScroll.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).perform();
		Thread.sleep(3000);
		builderScroll.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).keyUp(Keys.CONTROL).perform();
		Thread.sleep(3000);
		//builderScroll.sendKeys(Keys.SPACE).perform();
		//Thread.sleep(1000);
		
		
		//7. Check if the items displayed are sorted correctly
		List<WebElement> priceList=driver.findElements(By.xpath("//div[@class='lfloat marR10']/span[@class='lfloat product-price']"));
		boolean sort = false;
		for (int i = 0; i < priceList.size()-1; i++) {
			String TshoePrice =priceList.get(i).getText();
			String replaceTshoePrice = TshoePrice.replaceAll("[^0-9]", "");
			int ShoePriceT = Integer.parseInt(replaceTshoePrice);
			
			String TshoePrice1 =priceList.get(i+1).getText();
			String replaceTshoePrice1 = TshoePrice1.replaceAll("[^0-9]", "");
			int ShoePriceT1 = Integer.parseInt(replaceTshoePrice1);
			
			if(ShoePriceT1>ShoePriceT) {
				
				sort=true;
				break;
			}
		}
		if(sort) {
			System.out.println("Displayed items are not sorted");
		}
		else
		{
			System.out.println("Displayed items are sorted");
		}
			//System.out.println(priceList.size());
		//8. Mouse Hover on puma Blue Training shoes
		
		WebElement trainingshoe = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[2]"));
		Actions builderTS=new Actions(driver);
		builderTS.moveToElement(trainingshoe).perform();
		
		
		//9. click QuickView button
		driver.findElement(By.xpath("((//img[@class='product-image wooble'])[2]/following::div)[2]")).click();
		
		//10. Print the cost and the discount percentage
		System.out.println("Shoe cost: "+driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText());
		System.out.println("Shoe discount%: "+driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText());
		 
		
		// 11. Take the snapshot of the shoes.
		File source=driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./snaps/Shoe.png");
		FileUtils.copyFile(source, destination);
		
		//12.Close the current window
		driver.close();
		
		System.out.println("Testcase Done.Closing browser");
		
		//13.Close the main window
		driver.quit();
		
		
			
			
		
	}

}
