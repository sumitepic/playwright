package playwright1.playwright1;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class First extends Base {

	
	//@Test
	public void normalRun() {
		page.click(ObjectRepository.gmail);
		clickUse(ObjectRepository.signIn, page);

	}

	@Test
	public void dropdown() {
		boolean flag= false;
		
		System.out.println("facebook");
		flag=true;
		GenerateReport("Facebook Login");
		GenerateReport("Search");
	}

}