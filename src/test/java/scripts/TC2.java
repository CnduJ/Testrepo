package scripts;

import objectRepository.LoginPage;

import org.testng.annotations.Test;

import config.StartBrowser;
import reUse.CommonMethods;
import util.Xls_Reader;
import webdriverComments.ActionDriver;

public class TC2 extends StartBrowser {
	 public Xls_Reader reader;

	@Test
  public void test_InvalidLogint() throws Exception {
	  CommonMethods cm=new CommonMethods();
	  ActionDriver aDriver=new ActionDriver();
reader=new Xls_Reader("TestData/Data1.xlsx");	 
for(int i=2;i<reader.getRowCount("Sheet1");i++)
{
	
cm.ims_enterUserCredentails(reader.getCellData("Sheet1", "UserName", i),reader.getCellData("Sheet1","Password", i));
	  if(aDriver.isElementPresent(LoginPage.msgInvalid))
	  {
		//  reader = new Xls_Reader("TestData/Data1.xlsx");
			
		  System.out.println("Invalid username/password");
	  }
	  else
	  {
		  System.out.println("Valid username and password");
		  cm.inspectSelection();
		  cm.ims_logout();
	  }
}
  }
}
