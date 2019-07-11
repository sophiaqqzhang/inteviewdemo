package interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrestashopService {

	public void validateTheTotalPrice(WebDriver driver, float goods1Price, float goods2Price) {
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

	public float addGoods2ToCart(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='thumbnail product-thumbnail']/img[@alt='Pack Mug + Framed poster']")).click();
		Thread.sleep(2000);
		WebElement goods2 = driver.findElement(By.xpath("//div[@class='current-price']/span"));//get the price
		float goods2Price = getPriceFromElement(goods2);

		driver.findElement(By.xpath("//div[@class='add']/button[@data-button-action='add-to-cart']")).click();//add to cart
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("p:last-of-type +div.cart-content-btn>a")).click();//check out
		Thread.sleep(3000);
		return goods2Price;
	}

	public float addFristGoodsToCart(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='thumbnail product-thumbnail']/img[@alt='Mug Today is a good day']")).click();
		Thread.sleep(2000);
		WebElement goods1=driver.findElement(By.xpath("//div[@class='current-price']/span"));//get the price
		float goods1Price = getPriceFromElement(goods1);
		
		driver.findElement(By.xpath("//div[@class='add']/button[@data-button-action='add-to-cart']")).click();//add to cart
		
		Thread.sleep(5000);

		driver.findElement(By.cssSelector("p:last-of-type +div.cart-content-btn>button")).click();//continue shopping
		Thread.sleep(3000);
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(2000);
		return goods1Price;
	}

	private float getPriceFromElement(WebElement goods) {
		String goodsPriceTag=goods.getText();
		String goodsPriceTagWithoutCurrency=goodsPriceTag.substring(1);
		float  goodsPrice = Float.parseFloat(goodsPriceTagWithoutCurrency);
		return goodsPrice;
	}

	public void searchKeywordMug(WebDriver driver) throws InterruptedException {
		driver.findElement(By.cssSelector("input.ui-autocomplete-input")).sendKeys("Mug");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
	}

	public void signup(WebDriver driver) throws InterruptedException {
		//sign-in
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		Thread.sleep(3000);
		//sign-up
		driver.findElement(By.cssSelector("div.no-account>a")).click();
		
		//fill the required info
		//radio button
		driver.findElement(By.xpath("//span[@class='custom-radio']/input[@value=2]")).click();
		
		char c = randomCharGenerator();
		//input first name
		driver.findElement(By.name("firstname")).sendKeys("xiaohua" + c);
		//input last name
		driver.findElement(By.name("lastname")).sendKeys("Wang" + c);
		//input email address
		driver.findElement(By.name("email")).sendKeys("581" + c + "@qq.com");
		//input password
		driver.findElement(By.name("password")).sendKeys("10010#110@42");
		//input birthday
		driver.findElement(By.name("birthday")).sendKeys("07/14/1996");
		//save
		driver.findElement(By.xpath("//footer[@class='form-footer clearfix']/button[@type='submit']")).click();
	}

	private char randomCharGenerator() {
		char c='a';
		return (char)(c+(int)(Math.random()*26));
	}
}
