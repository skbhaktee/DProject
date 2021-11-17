package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.HelperMethod;

public class LoginPage {

	public static String baseurl="https://mail.rediff.com/cgi-bin/login.cgi";
	private By userbox=By.xpath("//input[@id='login1']");
	private By passbox=By.xpath("//input[@id='password']");
	private By loginbtn=By.xpath("//*[@name='proceed']");
	
	
	WebDriver driver;

	public LoginPage(WebDriver idriver) {
		this.driver = idriver;
	}
	
	public void doLoginAs(String user,String pass) {
		
		HelperMethod hm= new HelperMethod(driver);
		driver.get(baseurl);
		hm.enterText(userbox, user);
		hm.enterText(passbox, pass);
		hm.clickBtn(loginbtn);
		
	}

}
