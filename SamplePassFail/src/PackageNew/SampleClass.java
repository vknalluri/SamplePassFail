package PackageNew;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class SampleClass {
	public static String DEVKEY="d195d8ee3c795e9af9ccc974f082d1f3";
	public static String URL="http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";

	public static void reportResult(String TestProject,String TestPlan,String Testcase,String Build,String Notes,String Result) throws TestLinkAPIException{
	TestLinkAPIClient api=new TestLinkAPIClient(DEVKEY, URL);
	api.reportTestCaseResult(TestProject, TestPlan,Testcase,Build, Notes, Result);
	}
	@Test
	public void Test1()throws Exception
	{
		SampleClass a=new SampleClass();
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
	//WebDriver driver=new ChromeDriver();
	//WebDriverWait wait=new WebDriverWait(driver, 6);
	String testProject="Web Application";
	String testPlan="regression1";
	//String Platform="Windows 10";
	String testCase="WA-1";
	String build="1.0";
	String notes=null;
	String result=null;
	try{
	driver.manage().window().maximize();
	driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1");
	/*driver.findElement(By.id("Email")).sendKeys("testlink.msoftgp");
	driver.findElement(By.id("Passwd")).sendKeys("*******");
	driver.findElement(By.id("signIn")).click();
	driver.switchTo().defaultContent();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("+Testlink")));*/
	result= TestLinkAPIResults.TEST_PASSED;
	notes="Executed successfully";
	}
	catch(Exception e){
	result=TestLinkAPIResults.TEST_FAILED;
	notes="Execution failed";
	}
	finally{

	a.reportResult(testProject, testPlan, testCase, build, notes, result);
	driver.quit();
	}
	}
}


