package Functional_testing02.App;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class App 
{


	public WebDriver driver;
	
	
	@BeforeTest
	public void beforeTest() {
		//System.out.println("The current working directory is " + System.getProperty("user.name"));
		System.setProperty("webdriver.chrome.driver", "/tmp/chromedriver");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Vinay\\chrome_driver\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.addArguments("--headless");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Vinay\\chrome_driver\\chromedriver_win32\\chromedriver.exe");
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		//Create a instance of your web driver
		driver = new ChromeDriver(chromeOptions);

	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test()
	public void Login_check() {	
		/*if(System.getProperty("URL")!= null)
		{
		driver.navigate().to(System.getProperty("URL"));
		}
		else
		{ */
			driver.navigate().to("http://cicdpipelineelb-1801309457.us-east-1.elb.amazonaws.com/LoginWebApps");
		//}
		driver.manage().window().maximize();
		driver.findElement(By.id("inputEmail")).sendKeys("vinay");
		driver.findElement(By.id("inputpassword")).sendKeys("kumar");
		driver.findElement(By.id("loginbutton")).click();
		String url = driver.getCurrentUrl();
	}
	

	
	@Test()
	public void Register() {	
		driver.navigate().to("http://cicdpipelineelb-1801309457.us-east-1.elb.amazonaws.com/LoginWebApps");
		
		driver.findElement(By.xpath("//a[text()='Register Here!']")).click(); 
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		driver.findElement(By.id("firstName")).sendKeys("suresh");
		driver.findElement(By.id("lastname")).sendKeys("kumar");
		driver.findElement(By.id("emailid")).sendKeys("vinay");
		driver.findElement(By.id("username")).sendKeys("kumar");
		driver.findElement(By.id("password")).sendKeys("kumar");
		driver.findElement(By.id("sub_reg")).click();
		System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
	
	}
	
	
	@Test()
	public void logout() {	
		driver.navigate().to("http://cicdpipelineelb-1801309457.us-east-1.elb.amazonaws.com/LoginWebApps");

		driver.manage().window().maximize();
		driver.findElement(By.id("inputEmail")).sendKeys("vinay");
		driver.findElement(By.id("inputpassword")).sendKeys("kumar");
		driver.findElement(By.id("loginbutton")).click();
		
		driver.navigate().to(driver.getCurrentUrl());
	    driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Log out']")).click(); 
		System.out.println(driver.getCurrentUrl());
		
	}
	
	@Test()
	public void navigate() {	
		
		driver.navigate().to("http://cicdpipelineelb-1801309457.us-east-1.elb.amazonaws.com/LoginWebApps");

		driver.manage().window().maximize();
		driver.findElement(By.id("inputEmail")).sendKeys("vinay");
		driver.findElement(By.id("inputpassword")).sendKeys("kumar");
		driver.findElement(By.id("loginbutton")).click(); 
		driver.findElement(By.xpath("//a[text()='AI/ML Chatbot']")).click(); 
		
				
	  }
	@Test()
	public void openchatbot() {	
		
		driver.navigate().to("http://cicdpipelineelb-1801309457.us-east-1.elb.amazonaws.com/LoginWebApps");

		driver.manage().window().maximize();
		driver.findElement(By.id("inputEmail")).sendKeys("vinay");
		driver.findElement(By.id("inputpassword")).sendKeys("kumar");
		driver.findElement(By.id("loginbutton")).click(); 
		driver.findElement(By.xpath("//a[text()='AI/ML Chatbot']")).click(); 
		
		
		System.out.println("Current URL "+driver.getCurrentUrl());
	    driver.findElement(By.id("chatbotico")).click();
	    sleep(10);
	    driver.findElement(By.id("chatbot")).click();
	    sleep(10);
	    	
	}

	
	
	
}
