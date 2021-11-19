package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.HelperMethod;

public class Login_Pom {

	public static String baseurl="https://mail.rediff.com/cgi-bin/login.cgi";
	private By userbox=By.xpath("//input[@id='login1']");
	private By passbox=By.xpath("//input[@id='password']");
	private By loginbtn=By.xpath("//*[@name='proceed']");
	
	
	WebDriver driver;

	public Login_Pom(WebDriver idriver) {
		this.driver = idriver;
	}
	
	public void doLoginAs(String user,String pass) {
		
	
		driver.get(baseurl);
		driver.findElement(userbox).sendKeys(user);
		driver.findElement(passbox).sendKeys(pass);
		driver.findElement(loginbtn).click();
		
	}

}
