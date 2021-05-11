package k;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Keywords {
	static WebDriver driver;
	static FileInputStream file;
	static Properties prop;
	static Robot robot;
	
	public void openbrowser()throws Exception  {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\workspace\\zohomav\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\win10\\workspace\\sample\\driver\\geckodriver.exe");
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 file = new FileInputStream("C:\\Users\\win10\\workspace\\zohomav\\prop.properties");
		 prop = new Properties();
		 prop.load(file);
		 
	}

	public void navigate(String data) {
driver.get(data);		
	}

	public void input(String data, String objectname) {
		driver.findElement(By.xpath(prop.getProperty(objectname))).sendKeys(data);
		
	}

	public void click(String objectname) {
        driver.findElement(By.xpath(prop.getProperty(objectname))).click();	
	}

	public void droupdown(String data,String objectname) throws Exception {
		driver.findElement(By.xpath(prop.getProperty(objectname))).click();
	//WebElement	selectbox = driver.findElement(By.xpath(prop.getProperty(objectname)));
	//Select selectitem = new Select (selectbox);
	//selectitem.selectByIndex(1);
		 robot = new Robot();
		if(data.equals("Mr.")){
			robot.keyPress(KeyEvent.VK_M);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_M);
			robot.keyRelease(KeyEvent.VK_R);
			robot.keyRelease(KeyEvent.VK_ENTER);
			}
		if(data.equals("Dr."))
		robot.keyPress(KeyEvent.VK_D);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}

	public void box(String objectname) throws Exception {
		driver.findElement(By.xpath(prop.getProperty(objectname))).click();
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_O);
		robot.keyRelease(KeyEvent.VK_O);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void exit() {
driver.close();		
	}

	public String title() {
String actualvalue=driver.getTitle();		
return actualvalue ;

	}

	public String verifytext(String objectname) {
		String actualvalue= driver.findElement(By.xpath(prop.getProperty(objectname))).getText();
		return actualvalue;
	}

	public String verieditbox(String objectname) {
String actualvalue = driver.findElement(By.xpath(prop.getProperty(objectname))).getAttribute("value");
return actualvalue;
	}

}
