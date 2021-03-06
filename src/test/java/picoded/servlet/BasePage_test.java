package picoded.servlet;

import static org.junit.Assert.assertNotNull;

import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.junit.Test;

import picoded.servlet.util.EmbeddedServlet;
import picoded.TestConfig;

public class BasePage_test {

	//
	// The test folders to use 
	//

	int testPort = 0;
	EmbeddedServlet testServlet = null;


	@Before
	public void setUp() {
		testPort = TestConfig.issuePortNumber();
		testServlet = null;
	}


	/**
	 * Hello world test class
	 */
	public class HelloWorld extends BasePage {
		
		@RequestPath("hello")
		public void helloWorld() { 
			getPrintWriter().println("world");
		}
	}

	@Test
	public void testHelloPath() throws Exception {
		assertNotNull(testServlet = new EmbeddedServlet(testPort, new HelloWorld()));
		String testUrl = "http://localhost:"+testPort+"/hello";
		
	}

}