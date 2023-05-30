package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this class contains element and respective business libraries of skillrary home page
 * @author Mithun
 *
 */
public class SkillraryHomePage {
	//declaration
	
	@FindBy(xpath= "//img[@alt='SkillRary']")
	private WebElement logo;
	
	@FindBy(xpath= "//ul[contains(@class,'home_menu list-unstyled list-inline')]/li[contains(@class,'dropdown')][1]/a[contains(@class,'dropdown-toggle ignorelink')][1]")
	private WebElement languageIcon;
	
	@FindBy(xpath= "//li[1]/a[contains(@class,'multi_lang')]")
	private WebElement english;
	
	@FindBy(xpath= "//li[3]/a[@class='dropdown-toggle ignorelink']")
	private WebElement gearsTab;
	
	@FindBy(xpath= "//ul[contains(@class,'dropdown-menu gear_menu')]/li[7]/a[text()=' SkillRary Demo APP']")
	private WebElement skillraryDemoAppLink;
	
	//initialization
	public SkillraryHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	/**
	 * this method return logo
	 * @return
	 */
	public WebElement getLogo() {
		return logo;
	}
	
	/**
	 * this method is used to select English as default language
	 */
	public void chooseEnglish() {
		languageIcon.click();
		english.click();
	}
	
	/**
	 * this method is used to click on gears tab
	 */
	public void clickGearsTab() {
		gearsTab.click();
	}
	
	/**
	 * this method is used to click on SkillraryDemoAppLink
	 */
	public void clickSkillraryDemoAppLink() {
		skillraryDemoAppLink.click();
	}
	
	
	
	
	
	
	
	
	
	
	

}
