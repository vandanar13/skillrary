package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WedDriverUtility;
/**
* this class contains elements locators and respective business libraries of selenium training page 
 * @author Mithun
 *
 */
public class SeleniumTrainingPage {

	// declartion
	
	@FindBy(xpath = "//h1[@class = 'page-header']")
	private WebElement pageHeader;
	
	@FindBy(id = "quantity")
	private WebElement quantity;
	
	@FindBy(id = "add")
	private WebElement plusButton;
	
	@FindBy(xpath = "//button[.=' Add to Cart']")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//div[@class='callout callout-success']/span")
	private WebElement itemAddedMessage;

	//Initilazation
	public SeleniumTrainingPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	/**
	 * this method returns page header  text
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	/**
	 * this method is used to fetch the quantity of product
	 * @return
	 */
	public String getQuantity() {
		return quantity.getAttribute("value");
	}
	/**
	 * this method is used to double click on plus button
	 * @param web
	 */
	public void doubleClickPlusButton(WedDriverUtility web) {
		web.doubleClickOnElement(plusButton);
	}
	/**
	 * this method is used to click on add to cart button
	 */
	public void clickAddCart() {
		addToCartButton.click();
	}
	/**
	 * this method is used to fetch item added message
	 * @return
	 */
	public String getItemAddedMessage() {
		return itemAddedMessage.getText();
	}
	
	}
	
