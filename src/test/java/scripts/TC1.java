package scripts;

import objectRepository.Homepage;

import org.testng.annotations.Test;

import config.StartBrowser;
import reUse.CommonMethods;
import webdriverComments.ActionDriver;

public class TC1 extends StartBrowser {
  @Test
  public void testLogin_Logout() throws Exception {
	  CommonMethods cm=new CommonMethods();
	  cm.ims_login();
  
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