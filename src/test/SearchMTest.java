import static org.junit.Assert.*;

import org.junit.Before;
//import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchMTest extends BaseTest{

	private String searchStr = "m";
	private int resultsAmountExpected = 3;
	String firstCode = "JNB";
	String secondCode = "BOM";
	String thirdCode = "SYD";
	
	@Before
	public void setUp(){
		driver.findElement(By.className("location-search")).sendKeys(searchStr);
	}
//@Ignore
	@Test
	public void searchMresultsAmountOutbound() throws InterruptedException {
//		assertTrue(driver.findElement(By.className("location-search")).isDisplayed());
		WebElement element = driver.findElement(By.className("location-search"));
		element.click(); // click is unnecessary in this case, just showing usage of web element
//		element.sendKeys(searchStr);
		assertEquals(resultsAmountExpected, driver.findElements(By.className("destination")).size());
	
	}
//@Ignore
	@Test
	public void searchMresultsAmountInbound() throws InterruptedException {
		// click Inbound
		driver.findElement(By.xpath("//div[text()='Inbound']")).click();
		// type in search text field
		//driver.findElement(By.className("location-search")).sendKeys(searchStr);
		//assertion (Expected, Actual)
		assertEquals(resultsAmountExpected, driver.findElements(By.className("destination")).size());
//		System.out.println(driver.findElements(By.className("destination")).size());
//		Thread.sleep(3000); //temporary delay for visual inspection 
	}
	
	@Test //BONUS
	public void searchMfirstAirportCodesOutbound() throws InterruptedException {
		String code = driver.findElement(By.xpath("//div[1]/p/span[@class= 'iata']")).getText();
		code = code.replaceAll("\\(", "").replaceAll("\\)", ""); //removing parentheses
		assertEquals(firstCode, code);
	}
	@Test //BONUS
	public void searchMsecondAirportCodesOutbound() throws InterruptedException {
		String code = driver.findElement(By.xpath("//div[2]/p/span[@class= 'iata']")).getText().replaceAll("\\(", "").replaceAll("\\)", "");
		assertEquals(secondCode, code);
	}
	@Test //BONUS
	public void searchMthirdAirportCodesOutbound() throws InterruptedException {
		assertEquals(thirdCode, driver.findElement(By.xpath("//div[3]/p/span[@class= 'iata']")).getText().replaceAll("\\(", "").replaceAll("\\)", ""));
	}
	

}
