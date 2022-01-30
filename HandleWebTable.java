package handleWebTable;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWebTable {
	static WebDriver driver;
	
	
	@BeforeMethod
	public void getData() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://seleniumpractise.blogspot.com/2021/08/");
		
			
		}
		
	
	@Test
	public void main() {
		
		List<WebElement> cName =driver.findElements(By.xpath("//tr/th"));
		int number = cName.size();
		System.out.println(number);
		
		for(WebElement str:cName) {
			String st = str.getText();
			System.out.println(st);
			Assert.assertEquals(number, 5);
			
		}	
	}
	
	@Test(priority=1)
	public void getF_Row() throws InterruptedException {
		
	
	List<WebElement> row =driver.findElements(By.xpath("//table[@id='customers']//tr[2]"));
	int s = row.size();
	System.out.println(s);
	for (WebElement webElement : row) {
		
		System.out.println(webElement.getText());
		
	}
	
	List<WebElement> cBox =driver.findElements(By.xpath("//td//input[@type='checkbox']"));
	System.out.println(cBox.size());
	
	for (int i=0; i<cBox.size(); i++) {
		
		System.out.println(i);
		
		
//		if (i==1) {
//		
//			break;
//		}
		Thread.sleep(4000);
	}
	
	}
	
	
	
	
	
	private char[] element(List<WebElement> cBox) {
		// TODO Auto-generated method stub
		return null;
	}


	@AfterMethod
		public void tearDown() {
			driver.quit();
			
		}

	}

