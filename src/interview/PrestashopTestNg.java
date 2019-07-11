package interview;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;  
/*
 * 1. Register a new user and login;
 *    Access web site: http://fo.demo.prestashop.com/en/
 * 2. Search 'Mug'
 * 3. Add 2 'MUG TODAY IS A GOOD DAY' to cart
 * 4. Validate total price is correct on shopping cart page
 */
public class PrestashopTestNg {
	public WebDriver driver;

	@BeforeMethod
	public void beforeClass() throws InterruptedException {
		// Firefox
		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//navigate to the target page		
		driver.get(" http://fo.demo.prestashop.com/en/");
		driver.manage().window().maximize();	
	}

	@AfterMethod
	public void afterClass() {
	    //logout&quit   
	    driver.findElement(By.xpath("//div[@class='user-info']/a[@class='logout hidden-sm-down']")).click();//logout
	    driver.quit();  
	}

    @Test(dataProvider="registerdata",dataProviderClass=TestDataProvider.class)
	public void testPrice(String title,String firstname,String lastname,String email,String password,String birthday) throws Exception {	
	PrestashopService testService = new PrestashopService(driver);
	
	//1. Register a new user and login
	testService.signup(title,firstname,lastname, email, password, birthday);
    
    //2. Search 'Mug'
	testService.searchKeywordMug();
    
    //3. Add 2 'MUG TODAY IS A GOOD DAY' to cart
    
    //select the first goods
    float goods1Price = testService.addFristGoodsToCart(); 
    //select the second goods
    float goods2Price = testService.addGoods2ToCart();
    
    //4. Validate total price is correct on shopping cart page
    testService.validateTheTotalPrice(goods1Price, goods2Price);
   }

}

