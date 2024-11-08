package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features  = "src/test/java/fetures",
		
		glue ="stepdefinations", monochrome = true, tags = "@SmokeTest",
		
				plugin = { "pretty", "html:target/cucumber.html","json:target/cucumber.json" })

public class TestRunner extends AbstractTestNGCucumberTests {
	
			
			

	

}
