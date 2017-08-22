import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class SearchLonTest  extends BaseTest{

	private String searchStr = "Lon";
	private String expectedLocation = "London, UK";
	private String expectedGoogleLocation = "51°28'14.2\"N 0°27'43.0\"W";
	private int inboundFlightsAmount = 3;
	private int outboundFlightsAmount = 2;
	
	
	@Before
	public void setUp() throws Exception {
		driver.findElement(By.className("location-search")).sendKeys(searchStr);
	}

	@Test
	public void verifyResultLocation() {
		String locationFound = driver.findElement(By.cssSelector(".location")).getText();
		assertEquals(expectedLocation, locationFound);
	}
	
	@Test
	public void verifyOutboundFlightsAmount() {
		int outboundFlightsFound = driver.findElements(By.cssSelector(".route")).size();
		assertEquals(outboundFlightsAmount, outboundFlightsFound);	
	}
	
	@Test
	public void verifyInboundFlightsAmount() {
		driver.findElement(By.xpath("//div[text()='Inbound']")).click();
		int inboundFlightsFound = driver.findElements(By.cssSelector(".route")).size();
		assertEquals(inboundFlightsAmount, inboundFlightsFound);	
	}
	
	@Test //BONUS
	public void verifyGoogleLocation() {
		//switch to iframe required to access location element
		driver.switchTo().frame(driver.findElement(By.className("destination-map")));

		String expectedGoogleLocationFound = driver.findElement(By.cssSelector(".place-name")).getText();

		assertEquals(expectedGoogleLocation, expectedGoogleLocationFound);
//		driver.switchTo().defaultContent(); //Switch back to the main window if required by future actions
	}
}
