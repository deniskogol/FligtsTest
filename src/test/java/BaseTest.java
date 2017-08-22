import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest  {
	protected WebDriver driver;
	protected String baseUrl;
	protected WebDriverWait wait;
	
	@Before
	public void baseSetUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://sureprep-frontend-coding-challenge.s3-website-us-east-1.amazonaws.com";
		wait = new WebDriverWait(driver, 5);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(baseUrl);
//		String pageLoaded = ((JavascriptExecutor)driver).executeScript("return document.readyState").toString();
//		System.out.println("Home Page load is "+ pageLoaded);
	}
	
	@After 
	public void baseTearDown() throws Exception {
//		Thread.sleep(3000); // delay for visual debug purposes right before quit
		driver.quit();
  }
	
}
