package runner;

import io.cucumber.plugin.Plugin;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite //Junit test suite
@IncludeEngines("cucumber") //cucumber tests will be executed in Junit test suite
@SelectClasspathResource("features") //cucum.tests will be available in the features folder under src/test/resources
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value="json:target/out.json")
public class  TestRunner {
    //empty class
}
