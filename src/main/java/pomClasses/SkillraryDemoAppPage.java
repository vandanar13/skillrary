package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WedDriverUtility;

/**
 * this class contains element and respective business libraries of skillrary home page
 * @author Mithun
 * @param <driver>
 *
 */

public class SkillraryDemoAppPage<driver> {
	
	//declaration
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	private  WebElement pageHeader;
	
	@FindBy(id="course")
	private WebElement courseTab;
	
	@FindBy(xpath="//span/a[text()='Selenium Training']")
	private WebElement seleniumTrainingLink;
	
	@FindBy(name="addresstype")
	private WebElement categoryDD;
	
	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement contactUsLink;
	
	//Initialization
	
	public SkillraryDemoAppPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	/**
	 * this methos return page header text
	 * @return
	 */
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	/**
	 * this methos is used to mouseover to course link 
	 * @param web 
	 * @param web
	 */
	public void mouseHoverToCourse(WedDriverUtility web) {
		web.mouseHover(courseTab);
	}
	
	
	/**
	 * this method is used to click on selenium training
	 */
	
	public void clickSeleniumTraining() {
		seleniumTrainingLink.click();
	}
	
	/**
	 * this method is used to select category
	 * @param web
	 * @param index
	 */
	public void selectCategory(WedDriverUtility web, int index) {
		web.dropdown(categoryDD, index);
	}
	
	
	/**
	 * this method return contact us link
	 * @return
	 */
	
	public WebElement getContactUsLink() {
		return contactUsLink;
	}
	
	
	/**
	 * this method is used to click on contact us link
	 */
	
	public void clickContactUs() {
		contactUsLink.click();
	}
	
	
	

}
