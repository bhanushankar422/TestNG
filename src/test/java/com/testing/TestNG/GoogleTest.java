package com.testing.TestNG;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class GoogleTest {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {

		driver = new ChromeDriver();
	}

	@Test(description = "Test for selenium keyword")
	public void testSeleniumSearch() {
		testKeywordSearch("selenium");
	}
	
	@Test(description = "Test for java keyword")
	public void testJavaSearch() {
		testKeywordSearch("java");
	}

	private void testKeywordSearch(String keyword) {
		driver.get("https://www.google.com");
		  driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(keyword);
		  driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(Keys.ENTER);
		  String results = driver.findElement(By.xpath("//*[@id=\"result-stats\"]")).getText();
		  System.out.println(results);
		  assertTrue(results.contains("results"), "Found -> " + results);
		  driver.close();
	}
}
