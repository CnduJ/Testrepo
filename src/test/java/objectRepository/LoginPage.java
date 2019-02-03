package objectRepository;

import org.openqa.selenium.By;

public class LoginPage {
	public static By txtUsername=By.name("loginForm.Username");
	public static By txtPassword=By.name("loginForm.password");
	public static By btnSignin=By.xpath("//span[text()='Sign In']");
	public static By rbtInspect=By.xpath("(//div[@class='ui-radiobutton-box ui-widget ui-state-default'])[1]");
	public static By btnOkay=By.xpath("//span[text()='Okay']");
	public static By msgInvalid=By.xpath("//span[@class='ui-messages-detail']");

}
