package com.meetago.qa.testing;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class: ChangeBudget
 *
 */
public class ChangeBudget 
{
	
	protected WebDriver 			driver;
	protected JavascriptExecutor 	jse;
	protected String 				driverPrefix = "C:\\Users\\charl\\Software\\java\\selenium\\";
	protected String 				sessionLink = "https://m7-frontend.test/records/fake/mee4/123456/mee7/987654?_access_token=458741231";
	protected String 				startPage = "https://m7-frontend.test/records/details/746065";
	
	public void invokeBrowser()
	{
		try {
			System.setProperty("webdriver.chrome.driver", driverPrefix + "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			waitForPageLoaded(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitForPageLoaded(WebDriver driver)
	{
		ExpectedCondition<Boolean> expectations = new ExpectedCondition<Boolean>() {
			
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(expectations);
		driver.get(sessionLink);
		driver.get(startPage);
		updateBudget(driver);
	}
	
	
	public void updateBudget(WebDriver driver)
	{
		try {
			Thread.sleep(20000);
			int randomBudget = roundAmount(100 + new Random().nextInt(800));
			String budget = String.valueOf(randomBudget);
			driver.findElement(By.id("show-dialog-edit-budget")).click();
			driver.findElement(By.cssSelector("input.mee-input-wrapper__input.new-record-detail-budget")).clear();
			driver.findElement(By.cssSelector("input.mee-input-wrapper__input.new-record-detail-budget")).sendKeys(budget);
			driver.findElement(By.cssSelector("button.meeuser-button__info.record-details-save-budget.action-button.mdl-button.mee-button")).click();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int roundAmount(int pAmount)
	{
		return pAmount%10 == 0 ? pAmount : (pAmount + (10 - pAmount%10));
	}
	
	
    public static void main( String[] args )
    {
       ChangeBudget cBudget = new ChangeBudget();
       cBudget.invokeBrowser();
    }
}
