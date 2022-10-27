package stepDefenition;

import Util.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void beforeScenario() {

	}

	@After
	public void afterScenario() {
		BaseClass.driver.quit();
	}

}
