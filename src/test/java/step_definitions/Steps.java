package step_definitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;		

import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;		

public class Steps {				

    WebDriver driver;			
    		
    @Given("^Open the Firefox and launch the application$")					
    public void open_the_Firefox_and_launch_the_application() throws Throwable							
    {		
       System.setProperty("webdriver.gecko.driver", "C:\\Users\\ssgan\\eclipse-workspace\\geckodriver.exe");					
       driver= new FirefoxDriver();					
       driver.manage().window().maximize();			
       driver.get("http://demo.guru99.com/v4");					
    }		

    @When("^Enter the Username and Password$")					
    public void enter_the_Username_and_Password() throws Throwable 							
    {		
       driver.findElement(By.name("uid")).sendKeys("username12");							
       driver.findElement(By.name("password")).sendKeys("password12");							
    }		

    @Then("^Reset the credential$")					
    public void Reset_the_credential() throws Throwable 							
    {	
      TakesScreenshot srh = ((TakesScreenshot)driver);
  	  
  	  File srhfile = srh.getScreenshotAs(OutputType.FILE);
  	  
  	  File des = new File("C:\\Users\\ssgan\\eclipse-workspace\\123.png");
  	  
  	  
  	  FileUtils.copyFile(srhfile,des);
  	  
    	
       driver.findElement(By.name("btnReset")).click();		
       driver.quit();
    }		
}		