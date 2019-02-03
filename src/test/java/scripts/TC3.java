package scripts;

import objectRepository.Homepage;

import org.testng.annotations.Test;

import config.StartBrowser;
import reUse.CommonMethods;
import util.Xls_Reader;
import webdriverComments.ActionDriver;

public class TC3 extends StartBrowser {
	 public Xls_Reader reader;
  @Test
  public void testLogin_Logout_Data() throws Exception {
	  CommonMethods cm=new CommonMethods();
	  reader = new Xls_Reader("TestData/Data1.xlsx");
	 //for(int i=1;i<4;i++){
			 
	   String userName = reader.getCellData("Sheet1", "UserName", 2);
	  String password = reader.getCellData("Sheet1", "Password", 2);
	  cm.ims_login(userName, password);
  
  ActionDriver aDriver=new ActionDriver();
  if(aDriver.isElementPresent(Homepage.btnPrf))
  {
	  System.out.println("Login succesfuly");
	  cm.ims_logout();
  }
  else
  {
	  System.out.println("Unable to logout");
  }
}
}