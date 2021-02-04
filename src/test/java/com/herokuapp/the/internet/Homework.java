package com.herokuapp.the.internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework {
	
	@Test
	public void incorrectUsername() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers for Selenium\\NewCromeDriver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		
		WebDriver CHK=new ChromeDriver();
		
		//sleep for 3 sec
		Sleep();
		
		//maximise the browser
		CHK.manage().window().maximize();
		
		//open test page
		String url = "https://the-internet.herokuapp.com/login";
		CHK.get(url);
		System.out.println("Page is opened");
		System.out.println("Update");
		Sleep();
		
		//enter username
		WebElement userName = CHK.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("userame");
		//userName.sendKeys("tomsmith");
		
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
		
		//close browser
		CHK.close();
		
	}

	private void Sleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
