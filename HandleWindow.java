package handleWebTable;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindow {
	static WebDriver driver;
		public static void main(String[] args) throws Exception {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("alert,'My name is Khan'");
			
			Thread.sleep(4000);
			
			driver.findElement(By.id("newWindowBtn")).click();
			
			
			String st =driver.getWindowHandle();
			System.out.println("parents window "+st);
			Set<String>str =driver.getWindowHandles();
			
			System.out.println(str.size());
			Iterator<String> it =str.iterator();
			while(it.hasNext()) {
			String parent =it.next();
			System.out.println("main ="+parent);
			
			String child =it.next();
			System.out.println("child ="+child);
			
			driver.switchTo().window(child);
			TimeUnit.SECONDS.sleep(3);
			driver.findElement(By.id("firstName")).sendKeys("nazmul");
			driver.switchTo().window(parent);
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.id("newTabBtn")).click();
			
			
			
			}
			
	
//			
			
			
			
			
			//driver.quit();
			
	}

}
