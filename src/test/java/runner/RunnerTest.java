package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step_def",
        plugin = {
                "pretty",
                "html:target/cucumber-report/cucumber-pretty",
                "json:target/cucumber-report/CucumberTestReport.json"
        },


        tags = "@TeladocChallenge",
        dryRun = false
)
@RunWith(Cucumber.class)
public class RunnerTest  {


}
