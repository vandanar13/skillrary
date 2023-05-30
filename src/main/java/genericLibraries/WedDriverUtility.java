package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * this class contains all reusable methods of webDriver
 * @author Mithun
 *
 */
public class WedDriverUtility {
	private WebDriver driver;
	
	
	/**
	 * this is used to launch the browser
	 * @param browser
	 * @return 
	 */
	
	public WebDriver launchBrowser(String browser) {
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("invalid browser data");
				
		}
		return driver;
		
	}
	
	/**
	 * this method is used to maximize the browser
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	
    /**
     * this method is used to navigate the application via  url
     * @param url
     */
	public void navigateToApp(String url) {
		driver.get(url);
		
	}
	
	/**
	 * this method wait until the element or elements is found
	 * @param time
	 */
	public void waitUntilElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
	}
	
	/**
	 * this method is used to wait until element is displayed
	 * @param time
	 * @param element
	 * @return
	 */
	public WebElement explicityWait(long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * this method is used to wait until element is enabled
	 * @param element
	 * @param time
	 * @return
	 */
	public WebElement explicityWait(WebElement element, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * this method is wait until the web page title is dispalyed
	 * @param time
	 * @param title
	 * @return
	 */
	
	public boolean explicityWait(long time, String title ) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.titleContains(title));
	}
	
	/**
	 * this method is used to mouse hover to an element
	 * @param element
	 */
	public void mouseHover(WebElement element) {
		Actions actions = new Actions (driver);
		actions.moveToElement(element).perform();
		
	}
	
	/**
	 * this method is used to double click on an element
	 * @param element
	 */
	public void doubleClickOnElement(WebElement element) {
		Actions actions = new Actions (driver);
		actions.doubleClick(element).perform();
		
	}
	
	/**
	 * this method is used to right click on an element
	 * @param element
	 */
	public void rightClickr(WebElement element) {
		Actions actions = new Actions (driver);
		actions.contextClick(element).perform();
		
	}
	
	/**
	 * this method is used to drag and drop an element to target
	 * @param element
	 * @param target 
	 */
	public void dragAndDropElement(WebElement element, WebElement target) {
		Actions actions = new Actions (driver);
		actions.dragAndDrop(element,target).perform();
		
	}
	
	/**
	 * this method is used to select the element from drop down using index
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * this method is used to select the element from drop down using value
	 * @param element
	 * @param value
	 */
	public void dropdown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * this method is used to select the element from drop down using visible text
	 * @param text
	 * @param element
	 */
	public void dropdown(String text, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	
	/**
	 * this method is used to scroll till the element
	 * @param element
	 */
	public void scrollTillElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
   
	
	/**
    * this method is used to switch to frame using index
    * @param index
    */
	public void switchToFrame(int index ) {
		driver.switchTo().frame(index);
	}
	
	
	/**
	 * this method is used to switch to frame using id or Name attribute value
	 * @param idOrName
	 */
	public void switchToFrame(String idOrName ) {
		driver.switchTo().frame(idOrName);
	}
	
	
	/**
	 * this method is used to switch to frame using frame Element
	 * @param frameElement
	 */
	public void switchToFrame(WebElement frameElement ) {
		driver.switchTo().frame(frameElement);
	}
	
	
	/**
	 * this method is used to switch back from frame
	 */
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * this method is used to capture screenshot of window
	 * @param jUtil
	 */
	public void takeScreenshot(JavaUtility jUtil) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/SS_"+jUtil.getCurrentTime()+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * this method is used to handle the alert
	 * @param status
	 */
	public void handleAlert(String status) {
		Alert al = driver.switchTo().alert();
		if(status.equalsIgnoreCase("ok"))
		      al.accept();
	     else
			al.dismiss();
	}
	
	/**
	 * this method is used to switch to child browser
	 */
	public void switchToChlidbrowser() {
		Set<String> set = driver.getWindowHandles();
		for(String id: set) {
			driver.switchTo().window(id);
			}
		}
	
	/**
	 * this method is used to close the window
	 */
	public void closeCurrentWindow() {
		driver.close();
	}
	
	/**
	 * this method is used to exit all the windows
	 */
	public void quitAllWindows() {
		driver.quit();
	}
	















}
