package com.testing.TestNG;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class GoogleTestWithDataProvider {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {

		driver = new ChromeDriver();
	}

	@Test(dataProvider = "dp", description="Testing with DataProvider")
	public void f(Integer n, String s) {
		driver.get("https://www.google.com");
		  driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(s);
		  driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(Keys.ENTER);
		  String results = driver.findElement(By.xpath("//*[@id=\"result-stats\"]")).getText();
		  System.out.println(results);
		  assertTrue(results.contains("results"), "Found -> " + results);
		  driver.close();
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "selenium" }, new Object[] { 2, "java" }, };
	}
}
