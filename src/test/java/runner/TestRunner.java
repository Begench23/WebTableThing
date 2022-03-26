package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target/cucumberReport.html",
                    "rerun:target/failedReport.txt",
                "me.jvt.cucumber.report.PrettyReports:target/xpath"},



        features = "src/test/resources/features",
        glue = "stepDefs",
        dryRun = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE


)


public class TestRunner {
}
