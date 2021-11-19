package redifftest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pompages.Login_Pom;
import pompages.Mail_Pom;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class POM_TC_1 {
	WebDriver driver;
	Mail_Pom mp;
  @Test(dataProvider = "dp")
  public void f(HashMap<String, String> map) {
	  
	  try {
		mp.composeMail(map.get("email"), map.get("subject"), map.get("message"));
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  @DataProvider
  public Object[][] dp() throws IOException {
	  XSSFWorkbook wb = new XSSFWorkbook(".//src//test//resources//Files//ComposeMail.xlsx");
		XSSFSheet sheet = wb.getSheetAt(0);
		int allRows = sheet.getLastRowNum();
		int allCells = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[allRows][1];

		for (int i = 0; i < allRows; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			String key = "";
			String value = "";
			for (int j = 0; j < allCells; j++) {
				key = sheet.getRow(0).getCell(j).getStringCellValue();
				if (sheet.getRow(i + 1).getCell(j).getCellType().equals(CellType.STRING)) {

					value = sheet.getRow(i + 1).getCell(j).getStringCellValue();

				} else if (sheet.getRow(i + 1).getCell(j).getCellType().equals(CellType.NUMERIC)) {
					value = String.valueOf(sheet.getRow(i + 1).getCell(j).getNumericCellValue());
				} else if (sheet.getRow(i + 1).getCell(j).getCellType().equals(CellType.FORMULA)) {
					value = String.valueOf(sheet.getRow(i + 1).getCell(j).getCellFormula());
				}
				map.put(key, value);

			}
			obj[i][0] = map;

		}
		wb.close();

		return obj;
  }
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	  Login_Pom lp=new Login_Pom(driver);
	  lp.doLoginAs("your user", "password");
	  mp=new Mail_Pom(driver);
  }

}
