package reUse;

import objectRepository.Homepage;
import objectRepository.LoginPage;

import org.openqa.selenium.WebDriver;

import config.StartBrowser;
import util.Xls_Reader;
import webdriverComments.ActionDriver;

public class CommonMethods {
 public WebDriver driver;
 public ActionDriver aDriver;

 
  public CommonMethods()
  {
	  driver= StartBrowser.driver;
	  aDriver=new ActionDriver();
	  
  }
  
  /* 
   * this method is for login application
   */
  public void ims_login() throws Exception
  {
	  StartBrowser.childTest=StartBrowser.parentTest.createNode("Login to Application");
	  aDriver.navigateToApplication("http://ims-qa.tectoro.com");
	  aDriver.type(LoginPage.txtUsername, "admin1","Username Field");
	  aDriver.type(LoginPage.txtPassword, "test1","Password Field");
	  aDriver.click(LoginPage.btnSignin,"Submit button");	
	 
  }
  public void ims_login(String userName, String password) throws Exception
  {
	  StartBrowser.childTest=StartBrowser.parentTest.createNode("Login to Application");
	  aDriver.navigateToApplication("http://ims-qa.tectoro.com");
	  aDriver.type(LoginPage.txtUsername, userName,"Username Field");
	  aDriver.type(LoginPage.txtPassword, password,"Password Field");
	  aDriver.click(LoginPage.btnSignin,"Submit button");	
	
  }
  public void ims_enterUserCredentails(String username, String password) throws Exception
  {
	  StartBrowser.childTest=StartBrowser.parentTest.createNode("Navigate to application and Enter Crendentials");

	  aDriver.navigateToApplication("http://ims-qa.tectoro.com");
	  aDriver.type(LoginPage.txtUsername, username,"Username Field");
	  aDriver.type(LoginPage.txtPassword, password,"Password Field");
	  aDriver.click(LoginPage.btnSignin,"Login button");	 
  }
 
  public void inspectSelection() throws Exception
  {
  StartBrowser.childTest=StartBrowser.parentTest.createNode("Radio button selection");
  aDriver.click(LoginPage.rbtInspect,"radiobutton");
  aDriver.click(LoginPage.btnOkay,"Okaybutton");
  }
  public void ims_logout() throws Exception
  {
	  StartBrowser.childTest=StartBrowser.parentTest.createNode("Logout of the Application");

	  aDriver.click(Homepage.btnPrf,"Profile");
	  aDriver.click(Homepage.btnLogout,"Logout button");
  }
}

