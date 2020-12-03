package com.csis3275.BlackboxTests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AcceptRejectLeaveFormTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "c:/temp/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void acceptRejectLeaveForm() {
		driver.get("http://localhost:8080/");
		driver.manage().window().setSize(new Dimension(815, 680));
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("adminpass");
		driver.findElement(By.cssSelector(".btn")).click();
		driver.findElement(By.linkText("3")).click();
		{
			String value = driver.findElement(By.id("inputSickDays")).getAttribute("value");
			assertThat(value, is("14"));
		}
		driver.findElement(By.linkText("Back to Admin Page")).click();
		driver.findElement(By.linkText("5")).click();
		{
			String value = driver.findElement(By.id("inputSickDays")).getAttribute("value");
			assertThat(value, is("7"));
		}
		driver.findElement(By.linkText("Back to Admin Page")).click();
		driver.findElement(By.cssSelector("a > .btn")).click();
		driver.findElement(By.cssSelector(".table:nth-child(3) td:nth-child(2) > .btn")).click();
		driver.findElement(By.cssSelector("td:nth-child(2) > .btn")).click();
		driver.findElement(By.linkText("Back to Admin Page")).click();
		driver.findElement(By.linkText("3")).click();
		{
			String value = driver.findElement(By.id("inputSickDays")).getAttribute("value");
			assertThat(value, is("2"));
		}
		driver.findElement(By.linkText("Back to Admin Page")).click();
		driver.findElement(By.linkText("5")).click();
		{
			String value = driver.findElement(By.id("inputSickDays")).getAttribute("value");
			assertThat(value, is("6"));
		}
		driver.findElement(By.cssSelector(".btn-sm")).click();
		driver.findElement(By.id("username")).sendKeys("rita");
		driver.findElement(By.id("password")).sendKeys("ritapass");
		driver.findElement(By.cssSelector(".btn")).click();
		assertThat(driver.findElement(By.cssSelector(".card-body:nth-child(1) .card-header")).getText(),
				is("Application Status: approved"));
		driver.findElement(By.cssSelector(".btn-sm")).click();
		driver.findElement(By.id("username")).sendKeys("arie");
		driver.findElement(By.id("password")).sendKeys("ariepass");
		driver.findElement(By.cssSelector(".btn")).click();
		assertThat(driver.findElement(By.cssSelector(".text-white")).getText(), is("Application Status: approved"));
	}
}
