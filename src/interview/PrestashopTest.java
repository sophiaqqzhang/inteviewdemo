package interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;  
/*
 * 1. Register a new user and login;
 *    Access web site: http://fo.demo.prestashop.com/en/
 * 2. Search 'Mug'
 * 3. Add 2 'MUG TODAY IS A GOOD DAY' to cart
 * 4. Validate total price is correct on shopping cart page
 */
public class PrestashopTest {

	public static void main(String[] args)throws Exception{	
	//IE WebDriver driver = new InternetExplorerDriver();
	//Firefox
	System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	
	//navigate to the target page		
	driver.get(" http://fo.demo.prestashop.com/en/");
	Thread.sleep(20000);
	
	PrestashopService testService = new PrestashopService();

	driver.manage().window().maximize();	
	//1. Register a new user and login
	testService.signup(driver);
    
    //2. Search 'Mug'
	testService.searchKeywordMug(driver);
    
    //3. Add 2 'MUG TODAY IS A GOOD DAY' to cart
    
    //select the first goods
    float goods1Price = testService.addFristGoodsToCart(driver); 
    //select the second goods
    float goods2Price = testService.addGoods2ToCart(driver);
    
    //4. Validate total price is correct on shopping cart page
    testService.validateTheTotalPrice(driver, goods1Price, goods2Price);
    
    driver.findElement(By.xpath("//div[@class='user-info']/a[@class='logout hidden-sm-down']")).click();//logout
    driver.quit();  
   }

}

