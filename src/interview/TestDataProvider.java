package interview;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	@DataProvider(name="registerdata")
	public Object[][] nexusers(){
		return new Object[][] {
		   {"1","forrest","zhang","forrest.zhang@136.com","1234567","05/01/1991"},
		   {"1","robin","wang","robin.wang@136.com","1234567","05/01/1991"},
		   {"2","vick","ma","vick.ma@136.com","1234567","05/01/1991"},
		   {"1","wilson","li","wilson.li@136.com","1234567","05/01/1991"},
		   {"2","larry","hou","larry.hou@136.com","1234567","05/01/1991"},
		 };

	}

	
	

}
