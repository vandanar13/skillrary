package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * this class contains elements locators and respective business libraris of testing page
 * @author Mithun
 *
 */
public class TestingPage {
	
	// declaration
	
	
	@FindBy(xpath="//h1[@class='page-header']")
	private WebElement pageHeader;
	
	@FindBy(id="Python")
	private WebElement pythonImage;
	
	@FindBy(id="cartArea")
	private WebElement cartArea;
	
	@FindBy(xpath="//div[@class='icons']/descendant::i[@class='fa fa-facebook']")
	private WebElement facebookIcon;
	
	//Initaialization
	
	public TestingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	
	
	/**
	 * this method returns page header text
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
		
	}
	
	
	/**
	 * this method return python image
	 * @return
	 */
	
	public WebElement getPythonImage() {
		return pythonImage;
	}
	
	
	/**
	 * this method returns cart area element
	 * @return
	 */
	public WebElement getcartArea() {
		return cartArea;
		
	}
	
	
	/**
	 * this method retruns facebook icon
	 * @return
	 */
	public WebElement getFacebookIcon() {
		return facebookIcon;
	}
	
	
	/**
	 * this methos is used to click on facebook icon
	 */
	public void clickFacebookIcon() {
		facebookIcon.click();
	}
	

}
