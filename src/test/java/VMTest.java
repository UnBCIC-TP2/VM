import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags="@VMTest", glue="cucumber.test.steps", format="pretty",
 features="classpath:features/vm.feature", monochrome = true, dryRun = false)
public class VMTest {
	
}
