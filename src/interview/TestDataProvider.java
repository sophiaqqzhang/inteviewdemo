package interview;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	@DataProvider(name="registerdata")
	public Object[][] newusers(){
		return new Object[][] {
		   {"MRS","cindy","liu","cindy.liu@136.com","123456","05/01/1991"},
		   {"MRS","Anne","wang","Anne.W@136.com","123457","05/01/1991"}, 
		   {"MR","le","yong","le.y@136.com","123486","05/01/1991"},
		   {"MRS","daisy","ren","15802.r@136.com","129456","05/01/1991"}, 
		   {"MRS","lucy","cheng","190456@qq.com","013456","05/01/1991"},
		   {"MR","matthew","Ma","15823@qq.com","114456","05/01/1991"}, 
		   {"MRS","Grace","Guo","1236@qq.com","122656","05/01/1991"},
		   {"MR","tylor","yang","tylor.yn@136.com","1210956","05/01/1991"}, 
		   {"MR","lynn","lee","1008613@136.com","1231456","05/01/1991"},
		   {"MRS","yoyo","Zhu","yoyo.Z@136.com","784256","05/01/1991"}, 
		   {"MR","vince","chen","19612@qq.com","113456","05/01/1991"},
		   {"MRS","judy","yang","judy.yn@136.com","1214856","05/01/1991"},    
		   {"MR","David","Guo","1100006@qq.com","1043756","05/01/1991"},
		   {"MRS","lynn","lee","100118903@136.com","1235456","05/01/1991"},
		   {"MRS","yoyo","Zhu","yoyo.Z@136.com","784256","05/01/1991"}, 
		 };

	}

	
	

}
