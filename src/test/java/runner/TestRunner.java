package runner;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

//This class is a test suite configuration.
@Suite
//which test engine to run
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
public class TestRunner {
}