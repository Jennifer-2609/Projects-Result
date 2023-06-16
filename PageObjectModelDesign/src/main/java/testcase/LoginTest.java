package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class LoginTest extends ProjectSpecificMethod {

	@BeforeTest
	public void setup() {
		testName="CreateLead";
		testDescription="Create Lead with mandatory details";
		testCategory="funactional";
		testAuthor="jennifer";
		
	}
	
	
	@Test
	public void runLoginTest() {
		
		LoginPage lp=new LoginPage();
		lp.enterUserName().enterPassword().clickLogin();
		
		
	}
}
