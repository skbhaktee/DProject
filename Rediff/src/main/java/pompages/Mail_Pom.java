package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.HelperMethod;

public class Mail_Pom {

	
	private By writemail=By.xpath("//body/div[4]/div[2]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]");
	private By emailname=By.xpath("//input[@placeholder='Enter name or email']");
	private By subject=By.xpath("//input[@class='rd_inp_sub rd_subject_datacmp2']");
	private By compose=By.xpath("//body");
	private By  send=By.xpath("//body[1]/div[4]/div[2]/div[2]/div[2]/div[2]/ul[2]/li[2]/div[1]/div[1]/div[1]/a[1]/b[1]");
	
	WebDriver driver;

	public Mail_Pom(WebDriver idriver) {
		this.driver = idriver;
	}
	
	public void composeMail(String emailto,String subj,String mailbody) throws InterruptedException {
		
		
		
		driver.findElement(writemail).click();
		Thread.sleep(10000);
		for(int i=0;i<10;i++) {
			if(driver.findElement(emailname).isDisplayed()) {
				driver.findElement(emailname).sendKeys(emailto);
				break;
			}
			else {
				Thread.sleep(5000);
			}
		
		}
		Thread.sleep(10000);
		driver.findElement(subject).sendKeys(subj);
		Thread.sleep(10000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cke_1_contents']/iframe")));
		driver.findElement(compose).sendKeys(mailbody);
		Thread.sleep(10000);
		
		driver.switchTo().defaultContent();
		Thread.sleep(10000);

		driver.findElement(send).click();
		
		
		
	}

}
