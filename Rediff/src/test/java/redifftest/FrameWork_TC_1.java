package redifftest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.Mail;
import util.HelperMethod;

public class FrameWork_TC_1 {
  WebDriver driver;
	@Test
  public void f() {
	  
	  HelperMethod hp=new HelperMethod(driver);
	  
	  driver=hp.launchBrowser("chrome");
	  hp.openApp(LoginPage.baseurl);
	  
	  LoginPage lp=new LoginPage(driver);
	  lp.doLoginAs("rth143", "rock12");
	  
	  Mail m=new Mail(driver);
	  
	  String subj="echo \"# RediffProject\" >> README.md\n" + 
	  		"git init\n" + 
	  		"git add README.md\n" + 
	  		"git commit -m \"first commit\"\n" + 
	  		"git branch -M main\n" + 
	  		"git remote add origin https://github.com/Rakyesh24/RediffProject.git\n" + 
	  		"git push -u origin main\n" + 
	  		"\n" + 
	  		"\n" + 
	  		"or push an existing repository from the command line\n" + 
	  		"git remote add origin https://github.com/Rakyesh24/RediffProject.git\n" + 
	  		"git branch -M main\n" + 
	  		"git push -u origin main";
	  
	  
	  
	  m.composeMail("joy.1686@rediffmail.com", "first mail",subj);
	 
	  
  }
}
