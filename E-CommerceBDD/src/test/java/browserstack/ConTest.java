package browserstack;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.browserstack.local.Local;

public class ConTest {
	public static void main(String[] args) throws Throwable {
		//creates an instance of Local
		Local bsLocal = new Local();

	//replace <browserstack-accesskey> with your key. You can also set an environment variable - "BROWSERSTACK_ACCESS_KEY".
		HashMap<String, String> bsLocalArgs = new HashMap<String, String>();
		bsLocalArgs.put("key", "g4dQq823QMsLNUFrbzX3");

	//starts the Local instance with the required arguments
		bsLocal.start(bsLocalArgs);

		//check if BrowserStack local instance is running
		System.out.println(bsLocal.isRunning());

		//stop the Local instance
		bsLocal.stop();
	}
	
	

}
