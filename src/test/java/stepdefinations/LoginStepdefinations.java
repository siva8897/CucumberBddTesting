package stepdefinations;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepdefinations {

	TestContextSetup testContextSetup;

	public LoginStepdefinations(TestContextSetup testContextSetup) {

		this.testContextSetup = testContextSetup;

	}

	@Given("setup the entries in database")
	public void setup_the_entries_in_database() {

	}

	@When("launch the browser from config variables")
	public void launch_the_browser_from_config_variables() {

		System.out.println("driver" + TestContextSetup.driver);

	}

	@When("hit the home page url of Rahul site")
	public void hit_the_home_page_url_of_rahul_site() {

	}

	@Given("Rahul Practice Application")
	public void rahul_practice_application() throws InterruptedException {
		System.out.println("driver" + TestContextSetup.driver);

		WebDriverManager.chromedriver().setup();

		TestContextSetup.driver = new ChromeDriver();

		TestContextSetup.driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		TestContextSetup.driver.manage().window().maximize();
		Thread.sleep(5000);

	}

	@When("User has clicked on Radio button1")
	public void user_has_clicked_on_radio_button1() {

		TestContextSetup.driver.findElement(By.name("radioButton")).click();

	}

	@When("User has enter text in to Suggiestion text box {string};")
	public void user_has_enter_text_in_to_suggiestion_text_box(String Country) throws InterruptedException {

		WebElement count = TestContextSetup.driver.findElement(By.id("autocomplete"));

		count.click();
		Thread.sleep(2000);

		count.sendKeys("India");

		count.sendKeys(Keys.ARROW_DOWN);

		count.sendKeys(Keys.ENTER);

	}

	@When("User has select dropdownlist options")
	public void user_has_select_dropdownlist_options() {

		WebElement option = TestContextSetup.driver.findElement(By.id("dropdown-class-example"));

		Select drop = new Select(option);

		drop.selectByIndex(2);

	}

	@When("User has clicked on checkbox Option")
	public void user_has_clicked_on_checkbox_option() {

		TestContextSetup.driver.findElement(By.id("checkBoxOption2")).click();
	}

	@When("User has switchtonew window")
	public void user_has_switchtonew_window() throws InterruptedException {

		TestContextSetup.driver.findElement(By.id("openwindow")).click();

		Thread.sleep(5000);

		TestContextSetup.Paranetwindow = TestContextSetup.driver.getWindowHandle();

		Set<String> window = TestContextSetup.driver.getWindowHandles();

		Iterator<String> it = window.iterator();

		while (it.hasNext()) {

			String chiledwindow = it.next();

			if (!TestContextSetup.Paranetwindow.equals(chiledwindow)) {

				TestContextSetup.driver.switchTo().window(chiledwindow);

				TestContextSetup.driver.manage().window().maximize();

				TestContextSetup.driver.findElement(By.xpath("//a[text()='Access all our Courses']")).click();
				
				TestContextSetup.driver.close();

			}
		}
		
		TestContextSetup.driver.switchTo().window(TestContextSetup.Paranetwindow);

	}
	
	

	@When("User has switchtonew tab")
	public void user_has_switchtonew_tab() {
		
		TestContextSetup.driver.findElement(By.xpath("//a[text()='Open Tab']")).click();
		
		TestContextSetup.Paranetwindow=TestContextSetup.driver.getWindowHandle();
		
		Set<String> window1 =TestContextSetup.driver.getWindowHandles();
		
		Iterator<String> it=window1.iterator();
		
		while(it.hasNext()) {
			
			String chiledwindow1=it.next();
			
			if(!TestContextSetup.Paranetwindow.equals(chiledwindow1)) {
				
				TestContextSetup.driver.switchTo().window(chiledwindow1);
				
				TestContextSetup.driver.findElement(By.xpath("//a[text()='Access all our Courses']")).click();
				
				TestContextSetup.driver.close();
				
				
			}
		}
		
		TestContextSetup.driver.switchTo().window(TestContextSetup.Paranetwindow);

	}
	
	@When("User has Enter data into switchto Alert textbox {string};")
	public void user_has_enter_data_into_switchto_alert_textbox(String fname) {
		
		TestContextSetup.driver.findElement(By.name("enter-name")).sendKeys(fname);

	}

	@When("User has clicked on Alert box button")
	public void user_has_clicked_on_alert_box_button() {
		
		TestContextSetup.driver.findElement(By.id("alertbtn")).click();
	
	}
	
	@When("User has clicked on Ok button")
	public void user_has_clicked_on_ok_button() {
	
		TestContextSetup.driver.switchTo().alert().accept();
	}
	
	@When("User has Enter data into swith Alert textox {string};")
	public void user_has_enter_data_into_swith_alert_textox(String lname) {
	    
		TestContextSetup.driver.findElement(By.name("enter-name")).sendKeys(lname);
	}
	
	@When("User has clciked on Confirme button")
	public void user_has_clciked_on_confirme_button() {
	 
		TestContextSetup.driver.findElement(By.id("confirmbtn")).click();
	}

	@When("User has clicked on Cancel button")
	public void user_has_clicked_on_cancel_button() {
	    
		TestContextSetup.driver.switchTo().alert().dismiss();
	}
	
	@When("User has higlight on table row")
	public void user_has_higlight_on_table_row() {
	    
		TestContextSetup.highlight(TestContextSetup.driver.findElement(By.xpath("//table[@id=\"product\"]/tbody/tr[last()]")));
	}
	
	@When("User has higlight on table cell")
	public void user_has_higlight_on_table_cell() {
	 
		TestContextSetup.highlight(TestContextSetup.driver.findElement(By.xpath("//table[@id=\"product\"]/tbody/tr/td[3]")));
	}
	
	@When("User has clicked on Hide button")
	public void user_has_clicked_on_hide_button() {


		TestContextSetup.driver.findElement(By.id("hide-textbox")).click();
		
		JavascriptExecutor jsExecutor=(JavascriptExecutor)TestContextSetup.driver;
		
		jsExecutor.executeScript("document.getElementById('displayed-text').value='Puneeth';");
			
	}
	
	@When("User has higlight on table row td Manger")
	public void user_has_higlight_on_table_row_td_manger() throws InterruptedException {
	
		TestContextSetup.highlight(TestContextSetup.driver.findElement(By.xpath("//table[@id='product']/tbody/tr/td[text()='Manager']")));
		Thread.sleep(5000);
	}
	
	@When("User has clicked on Mouse over button")
	public void user_has_clicked_on_mouse_over_button() {
	  
		WebElement mus=TestContextSetup.driver.findElement(By.id("mousehover"));
		Actions mouse= new Actions(TestContextSetup.driver);
		
		mouse.moveToElement(mus).click().perform();
		
		
		

		
	}
	
	@When("User has switch on fraime")
	public void user_has_switch_on_fraime() {
	   
		TestContextSetup.driver.switchTo().frame("courses-iframe");
		
		TestContextSetup.driver.findElement(By.xpath("//a[@class=\"theme-btn register-btn\"]")).click();
	}


}
