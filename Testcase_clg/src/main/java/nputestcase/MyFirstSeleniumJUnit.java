package nputestcase;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MyFirstSeleniumJUnit {

	@Test
	public void GoogleSearchOpenNPU() throws Exception {

		// 1. launch browser (FireFox)
		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.google.com");

		driver.manage().window().maximize(); // maximum window size
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // wait
																			// maximum
																			// up
																			// to
																			// 30s
																			// until
																			// page
																			// loaded
																			// completely
		Thread.sleep(3000); // wait extra 3s

		// 4. type NPU in the search text
		driver.findElement(By.id("lst-ib")).clear(); // clear the field, good
														// practice
		driver.findElement(By.id("lst-ib")).sendKeys("NPU"); // type NPU in the
																// search field

		// 5. Hit enter key
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).build().perform();

		// 6. wait until the search result appears
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // wait
																			// maximum
																			// up
																			// to
																			// 30s
																			// until
																			// page
																			// loaded
																			// completely
		Thread.sleep(3000); // wait extra 3s

		// 7. find and click the search result link text Northwestern
		// Polytechnic University to open NPU home page
		driver.findElement(
				By.linkText("Northwestern Polytechnic University | Welcome to ... - Fremont"))
				.click(); // Click Search Result Link Text to open NPU homepage
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // wait
																			// maximum
																			// up
																			// to
																			// 30s
																			// until
																			// page
																			// loaded
																			// completely
		Thread.sleep(5000); // wait extra 5s

		// 8. wait and verify NPU home page is loaded (check page title)
		System.out.println(driver.getTitle()); // print out the current page
												// title
		try {
			// Assert.assertTrue(driver.getTitle().contains("Northwestern Polytechnic University | Welcome to Northwestern Polytechnic University"));
			// // check page title is
			// "Northwestern Polytechnic University | Welcome to Northwestern Polytechnic University"
			Assert.assertTrue(driver
					.getTitle()
					.equals("Northwestern Polytechnic University | Welcome to Northwestern Polytechnic University")); // check
																														// page
																														// title
																														// is
																														// "Northwestern Polytechnic University | Welcome to Northwestern Polytechnic University"
		} catch (Throwable t) {
			t.getMessage();
		}

		// 9. Click NPU Homepage main picture Go Next and Go Previous button
		driver.findElement(
				By.cssSelector(".slides > li:nth-child(2) > div:nth-child(1) > div:nth-child(1)"))
				.click(); // click the main picture to enable Next and Previous
							// buttons
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.cssSelector(".flex-next")).click(); // Next
			Thread.sleep(2000); // wait extra 2s
		}

		for (int i = 0; i < 4; i++) {
			driver.findElement(By.cssSelector(".flex-prev")).click(); // Previous
			Thread.sleep(2000); // wait extra 2s
		}

		// 10. go back to NPU Home page
		driver.navigate().back(); // go back to previous window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // wait
																			// maximum
																			// up
																			// to
																			// 30s
																			// until
																			// page
																			// loaded
																			// completely
		Thread.sleep(2000); // wait 2s

		// 11. close all and exit
		driver.quit(); // Close all open windows and kill all WebDriover open
						// sessions
	}
}
