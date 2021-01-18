package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Firefox {	
	
	static WebDriver driver;
	static Properties p = new Properties();


public static void main(String[] cla) throws InterruptedException, FileNotFoundException, IOException {
	Logger.getLogger("").setLevel(Level.OFF);	               // Suppress Warnings
	
	p.load(new FileInputStream("./input.properties"));

	System.out.println("Browser:" + p.getProperty("browser"));

	System.setProperty("webdriver.gecko.driver", "./firefox.sh");
	driver = new FirefoxDriver();
	
    final long start = System.currentTimeMillis();

	driver.get(p.getProperty("url"));
	
	System.out.println("Title: " + driver.getTitle());
	
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Thread.sleep(500);
	
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("lena.grihn@gmail.com");
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).sendKeys("amerika2021");
//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("id.email")))).sendKeys(p.getProperty("fb_email"));
	
//wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("pass")))).sendKeys(System.getenv(p.getProperty("password")));
	Thread.sleep(500);
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("xpath_login")))).click();
Thread.sleep(500);
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("xpath_timeline")))).click();
	
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("xpath_your_profile")))).click();
   

//String friends = driver.findElement(By.xpath("//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[3]/div/div/div[1]/div[1]/div/div/div[3]/div/div/div/div[1]/div/div/div[1]/div/div/div/div/div/a[4]/div[1]/span")).getText();
	//Thread.sleep(3000);	


wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("xpath_timeline")))).click();

wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("xpath_logOut")))).click();

	final long finish = System.currentTimeMillis();
	
driver.quit();

    System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");

	//System.out.println("You have " + friends + " friends");

}
}

