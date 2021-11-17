package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.HelperMethod;

public class Mail {

	
	private By writemail=By.xpath("//body/div[4]/div[2]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]");
	private By emailname=By.xpath("//input[@id='TO_IDcmp2']");
	private By subject=By.xpath("//body/div[4]/div[2]/div[2]/div[2]/div[2]/ul[2]/li[2]/div[1]/div[1]/ul[1]/li[4]/input[1]");
	private By compose=By.xpath("//body");
	private By  send=By.xpath("//body[1]/div[4]/div[2]/div[2]/div[2]/div[2]/ul[2]/li[2]/div[1]/div[1]/div[1]/a[1]/b[1]");
	
	WebDriver driver;

	public Mail(WebDriver idriver) {
		this.driver = idriver;
	}
	
	public void composeMail(String emailto,String subj,String mailbody) {
		
		HelperMethod hm= new HelperMethod(driver);
		
		hm.clickBtn(writemail);
		hm.waitforPage(10);
		hm.enterText(emailname, emailto);
		hm.waitforPage(10);
		hm.enterText(subject, subj);
		hm.waitforPage(10);
		
		hm.switchToFrame(By.xpath("//*[@id='cke_1_contents']/iframe"));
		hm.enterText(compose, mailbody);
		hm.waitforPage(10);
		
		hm.defaultcontent();
		hm.waitforPage(10);
		hm.clickBtn(send);
		
		
		
	}

}
