package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class CreateLead extends ProjectSpecificMethod {

	//public CreateLead(ChromeDriver driver) {
	//	this.driver=driver;
	//}
	
	public CreateLead enterFirstName() {
		try {
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Jenni");
			reportStep("firstname is entered sucessfully", "pass");
		} catch (Exception e) {
			reportStep("firstname is not entered sucessfully", "fail");
			
		}
		return this;
	}
	
	public CreateLead enterLastName() {
		try {
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("tina");
			reportStep("lastname is entered sucessfully", "pass");
		} catch (Exception e) {
			reportStep("lastname is not entered sucessfully", "fail");
		}
		return this;
	}
	
	public CreateLead enterCompanyName() {
		try {
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("oasys");
			reportStep("company name is entered sucessfully", "pass");
		} catch (Exception e) {
			reportStep("company name is not entered sucessfully", "fail");
		}
		return this;
	}
	
	public ViewLead clickCreateLead() {
		try {
			driver.findElement(By.name("submitButton")).click();
			reportStep("Create Lead is clicked sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Create Lead is not clicked", "fail");
		}
		return new ViewLead();
	}
}
