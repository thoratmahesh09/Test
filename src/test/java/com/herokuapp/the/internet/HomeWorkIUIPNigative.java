package com.herokuapp.the.internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeWorkIUIPNigative {
	
	private WebDriver CHK;
	
	@Parameters({"browser"})
	@BeforeMethod
	private void browserSetup(String browser) {
		
		switch (browser) {
		case "crome":
			System.setProperty("webdriver.chrome.driver", "D:\\Drivers for Selenium\\ChromeDriver\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			CHK=new ChromeDriver();
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "D:\\Drivers for Selenium\\GeckoDrivers\\geckodriver.exe");
			//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			CHK=new FirefoxDriver();
			break;
			
		default:
			System.out.println("Do not know how to start" +browser+ ", starting chrome browser by default");
			System.setProperty("webdriver.chrome.driver", "D:\\Drivers for Selenium\\ChromeDriver\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			CHK=new ChromeDriver();
			break;
		}
				
		//sleep for 3 sec
		Sleep();
		
		//maximise the browser
		CHK.manage().window().maximize();
		
	}
	
	@Test(priority = 1)
	public void incorrectUsernameFail() {
		
		System.out.println("Starting Incorrect username test with correct username");
		//open test page
		String url = "https://the-internet.herokuapp.com/login";
		CHK.get(url);
		System.out.println("Page is opened");
		Sleep();
		
		//enter username
		WebElement userName = CHK.findElement(By.xpath("//input[@name='username']"));
		//userName.sendKeys("userame");
		userName.sendKeys("tomsmith");
		
		//enter possword
		WebElement Password = CHK.findElement(By.xpath("//input[@name='password']"));
		Password.sendKeys("SuperSecretPassword!");
		
		//login Buttion
		WebElement loginButton = CHK.findElement(By.className("fa-sign-in"));
		loginButton.click();
		Sleep();
		
		//verification failuer login messege
		WebElement errorMassege = CHK.findElement(By.cssSelector("#flash"));
		String exptectedErrormassege = "Your username is invalid!";
		String actualErrormassege = errorMassege.getText();
		
		Assert.assertTrue(actualErrormassege.contains(exptectedErrormassege), "Actual error messege dosent match "
				+ "with expected error massege \nactual: "+actualErrormassege +" "
						+ "\nExpected: "+exptectedErrormassege+" ");
		Sleep();
		
	}

	@Test(priority =2)
	public void incorrectPasswordFail() {
		
			System.out.println("Starting Incorrect pasword test with correct password");
			
			//open test page
			String url = "https://the-internet.herokuapp.com/login";
			CHK.get(url);
			System.out.println("Page is opened");
			Sleep();
			
			//enter username
			WebElement userName = CHK.findElement(By.xpath("//input[@name='username']"));
			userName.sendKeys("tomsmith");
			
			//enter possword
			WebElement Password = CHK.findElement(By.xpath("//input[@name='password']"));
			//Password.sendKeys("Mahesh");
			Password.sendKeys("SuperSecretPassword!");
			
			//login Buttion
			WebElement loginButton = CHK.findElement(By.className("fa-sign-in"));
			loginButton.click();
			Sleep();
			
			//verification failuer login messege
			WebElement errorMassege = CHK.findElement(By.cssSelector("#flash"));
			String exptectedErrormassege = "Your password is invalid!";
			String actualErrormassege = errorMassege.getText();
			
			Assert.assertTrue(actualErrormassege.contains(exptectedErrormassege), "Actual error messege dosent match "
					+ "with expected error massege \nactual: "+actualErrormassege +" "
							+ "\nExpected: "+exptectedErrormassege+" ");
			Sleep();
	}

	
	private void Sleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}	
	@AfterMethod
	private void finalClose() {
		//close browser
		CHK.close();
		Sleep();
	}

}
