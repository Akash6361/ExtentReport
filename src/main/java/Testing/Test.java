package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class Test {
	WebDriver driver;
	
	@BeforeMethod
	public void  config() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Akash Gowda\\Desktop\\CGI-Automation Testing Core training\\SeleniumWorkspace\\src\\main\\resources\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	
	@org.testng.annotations.Test
	public void Validlogin() {
	    WebDriverWait wait = new WebDriverWait(driver, 100);
   		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
   		username.sendKeys("Admin");
   		WebElement password=driver.findElement(By.xpath("//div[@data-v-957b4417]/descendant::input[@name='password' and @placeholder='Password']"));
   		password.sendKeys("admin123");
   		WebElement submit=driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']/child::*[1]"));
   		submit.click();	
   		wait = new WebDriverWait(driver, 10); 
   		WebElement actual =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/child::*[1]")));
   		String h=actual.getText();
   	     String expected = "Dashboard";
   	   SoftAssert softAssert = new SoftAssert();
   	   softAssert.assertEquals(actual, expected);
		
	}
	@org.testng.annotations.Test
	 public void Blankusrname() throws InterruptedException {
	   	WebDriverWait wait = new WebDriverWait(driver, 10);
	   	WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-v-957b4417]/descendant::input[@name='username' and @placeholder='Username']")));

			username.sendKeys("");
			WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-v-957b4417]/descendant::input[@name='password' and @placeholder='Password']")));
			password.sendKeys("admin123");
			WebElement submit=driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']/child::*[1]"));
			submit.click();
			WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")));
			String s=error.getText();
			System.out.println(s);
			SoftAssert softAssert = new SoftAssert();
			System.out.println("the actaul is "+s);
	       String expected = "Required";
	       softAssert.assertEquals(s, expected,"the actual data and expected not matching");
	       Thread.sleep(1000);


     }
	@org.testng.annotations.Test
	   public void Blankpassword() throws InterruptedException {
		   	WebDriverWait wait = new WebDriverWait(driver, 10);
		   	WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-v-957b4417]/descendant::input[@name='username' and @placeholder='Username']")));
			username.sendKeys("Admin");
			WebElement password=driver.findElement(By.xpath("//div[@data-v-957b4417]/descendant::input[@name='password' and @placeholder='Password']"));
			password.sendKeys("");
			WebElement submit=driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']/child::*[1]"));
			submit.click();
			WebElement error = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
			String s=error.getText();
			System.out.println(s);
			SoftAssert softAssert = new SoftAssert();
			System.out.println("the actaul is "+s);
		      String expected = "Required";
		      softAssert.assertEquals(s, expected,"the actual data and expected not matching");
		      Thread.sleep(1000);
		      }
	
	@org.testng.annotations.Test
	public void Invalidusrname() throws InterruptedException {
	   	WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-v-957b4417]/descendant::input[@name='username' and @placeholder='Username']")));
			username.sendKeys("addddddd");
			WebElement password=driver.findElement(By.xpath("//div[@data-v-957b4417]/descendant::input[@name='password' and @placeholder='Password']"));
			password.sendKeys("admin123");
			WebElement submit=driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']/child::*[1]"));
			submit.click();	
			WebElement actual = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")));
			String s=actual.getText();
			SoftAssert softAssert = new SoftAssert();
			System.out.println("the actaul is "+s);
	       String expected = "Invalid credentails";
	       softAssert.assertEquals(actual, expected,"the actual data and expected not matching");
	       Thread.sleep(1000);
	   
	}
	
	@org.testng.annotations.Test
	 public void Invalidpassword() throws InterruptedException {
	   	WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-v-957b4417]/descendant::input[@name='username' and @placeholder='Username']")));
			username.sendKeys("addddddd");
			WebElement password=driver.findElement(By.xpath("//div[@data-v-957b4417]/descendant::input[@name='password' and @placeholder='Password']"));
			password.sendKeys("admin123");
			WebElement submit=driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']/child::*[1]"));
			submit.click();	
			WebElement actual = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")));
			String s=actual.getText();
			SoftAssert softAssert = new SoftAssert();
			System.out.println("the actaul is "+s);
	       String expected = "Invalid credentails";
	       softAssert.assertEquals(actual, expected,"the actual data and expected not matching");
	       Thread.sleep(1000);
	   }

	@org.testng.annotations.Test
	   public void Logout() {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-form-row']/descendant::input[@name='username']")));
			username.sendKeys("Admin");
			WebElement password=driver.findElement(By.xpath("//div[@data-v-957b4417]/descendant::input[@name='username' and @placeholder='Username']"));
			password.sendKeys("admin123");
			WebElement submit=driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']/child::*[1]"));
			submit.click();
			WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i.oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon")));
			btn.click();
			WebElement logout=driver.findElement(By.xpath("//a[@href='/web/index.php/auth/logout']"));
			logout.click();


	}
}
