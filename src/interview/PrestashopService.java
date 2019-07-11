package interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrestashopService {
	private WebDriver driver;
	
	public PrestashopService(final WebDriver driver) {
		this.driver = driver;
	}
	

	public void validateTheTotalPrice(float goods1Price, float goods2Price) {
		WebElement shipping=driver.findElement(By.xpath("//div[@id='cart-subtotal-shipping']/*[@class='value']"));
		float shippingCost = getPriceFromElement(shipping);
		print("the shipping is"+shippingCost);
		
		WebElement totalPriceElement = driver.findElement(By.xpath("//div[@class='cart-summary-line cart-total']/*[@class='value']"));
		float totalPrice = getPriceFromElement(totalPriceElement);
		print("the totalPrice is"+totalPrice);
		
		if (goods1Price+goods2Price+shippingCost==totalPrice){
			print("The total price was calculated correctly!");
		}else{
			print("The total price of goods has been miscalculated!");
		}
	}

	private void print(String text) {
		System.out.println(text);
	}

	public float addGoods2ToCart() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='thumbnail product-thumbnail']/img[@alt='Pack Mug + Framed poster']")).click();
		WebElement goods2 = driver.findElement(By.xpath("//div[@class='current-price']/span"));//get the price
		float goods2Price = getPriceFromElement(goods2);

		driver.findElement(By.xpath("//div[@class='add']/button[@data-button-action='add-to-cart']")).click();//add to cart
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("p:last-of-type +div.cart-content-btn>a")).click();//check out
		return goods2Price;
	}

	public float addFristGoodsToCart() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='thumbnail product-thumbnail']/img[@alt='Mug Today is a good day']")).click();
		WebElement goods1=driver.findElement(By.xpath("//div[@class='current-price']/span"));//get the price
		float goods1Price = getPriceFromElement(goods1);
		
		driver.findElement(By.xpath("//div[@class='add']/button[@data-button-action='add-to-cart']")).click();//add to cart
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("p:last-of-type +div.cart-content-btn>button")).click();//continue shopping
		driver.navigate().back();
		return goods1Price;
	}

    private float getPriceFromElement(WebElement goods) {
		String goodsPriceTag=goods.getText();
		String goodsPriceTagWithoutCurrency=goodsPriceTag.substring(1);
		float  goodsPrice = Float.parseFloat(goodsPriceTagWithoutCurrency);
		return goodsPrice;
	}
    
	public void searchKeywordMug() throws InterruptedException {
		driver.findElement(By.cssSelector("input.ui-autocomplete-input")).sendKeys("Mug");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	public void signup(String title,String firstname,String lastname,String email,String password,String birthday) throws InterruptedException {
		//sign-in
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		//sign-up
		driver.findElement(By.cssSelector("div.no-account>a")).click();
		//fill the required info
		//radio button
		driver.findElement(By.xpath("//span[@class='custom-radio']/input[@value="+ title + "]")).click();
		
		//input first name
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		//input last name
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		//input email address
		driver.findElement(By.name("email")).sendKeys(email);
		//input password
		driver.findElement(By.name("password")).sendKeys(password);
		//input birthday
		driver.findElement(By.name("birthday")).sendKeys(birthday);
		//save
		driver.findElement(By.xpath("//footer[@class='form-footer clearfix']/button[@type='submit']")).click();
	}
    
//    @Test(dataProvider="registerdata",dataProviderClass=TestDataProvider.class)
//    public void signup(WebDriver driver) throws InterruptedException {
//		//sign-in
//	driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
//	//sign-up
//	driver.findElement(By.cssSelector("div.no-account>a")).click();
//	//fill the required info
//	//radio button
//	WebElement MRS=driver.findElement(By.xpath("//span[@class='custom-radio']/input[@value=2]"));
//	WebElement MR=driver.findElement(By.xpath("//span[@class='custom-radio']/input[@value=1]"));
////	driver.findElement(By.xpath("//span[@class='custom-radio']/input[@value=1]")).click();
////	
//
//
//	WebElement firstName=driver.findElement(By.name("firstname"));
//	
//	WebElement lastName=driver.findElement(By.name("lastname"));
//
//	WebElement eMail=driver.findElement(By.name("email"));
//
//	WebElement passWord=driver.findElement(By.name("password"));
//
//	WebElement birthDay=driver.findElement(By.name("birthday"));
//	
//	
//	
//	}
//    
//    
//    @Test(dataProvider="registerdata",dataProviderClass=TestDataProvider.class)
//    public void register(WebElement title,String firstname,String lastname,String email,String password,String birthday){
//    	WebElement MRS=driver.findElement(By.xpath("//span[@class='custom-radio']/input[@value=2]"));
// 	    WebElement MR=driver.findElement(By.xpath("//span[@class='custom-radio']/input[@value=1]"));
//    	title.click();
//    	firstName.sendKeys(firstname);
//    	lastName.sendKeys(lastname);
//    	eMail.sendKeys(email);
//    	passWord.sendKeys(password);
//    	birthDay.sendKeys(birthday);
//    //save		
//    	driver.findElement(By.xpath("//footer[@class='form-footer clearfix']/button[@type='submit']")).click();		
//    }
    
    
}
