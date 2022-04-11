package com.frameworkstep;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
public static  WebDriver driver;
	
	public String text;
	//Setup Driver
	public static  void getDriver() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	//Get URL-	1
	public static void getUrl(String url) {
		driver.get(url);
	}
	//Get title-2
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	//Get current URL-3
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	//close Browser-4
	public static void close() {
        driver.close(); 
	}
	//quit-5
	public void quit() {
		driver.quit();
	}
	//locators by id-6
	public static WebElement elementById(String datas) {
        WebElement element = driver.findElement(By.id(datas));
        return element;
     }
	//locators by name-7
	public WebElement elementByName(String datas) {
		WebElement element = driver.findElement(By.name(datas));
		return element;
	}
	//locators by class-8
	public WebElement elementByClass(String datas) {
		WebElement element = driver.findElement(By.className(datas));
		return element;
	}
	//locators by xpath-9
	public WebElement elementByXpath(String datas) {
		WebElement element = driver.findElement(By.xpath(datas));
		return element;
	}
	//Sendkeys-10
	public static void sendkeys(WebElement element,String datas) {
		element.sendKeys(datas);
	}
	//click-11
	public void click(WebElement element) {
		element.click();
	}
	//get text-12
	public String getText(WebElement element) {
		   String text = element.getText();
		   return text;
	}
	//Get attribute-13
	public String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	//mouse over action-14
	public void mouseOverAction(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	//Drag and Drop-15
	public void dragAndDrop(WebElement source,WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}
	//Right click-16
	public void rightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	//doubleClick-17
	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	//Simple alert-18
	public Alert simpleAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return alert;
	}
	//ConfirmAlert-19
	public Alert confirmAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		return alert;
	}
	//Prompt Alert-20
	public Alert promptAlertSendkeys(String datas) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(datas);
		return alert;
	}
	//prompt alert with gettext-21
	public String proAlertGetText() {
		Alert alert = driver.switchTo().alert();
		String text2 = alert.getText();
		return text2;
	}
	//navigate to url-22
	public void navigateUrl(String url) {
		driver.navigate().to(url);
	}
	//navigate to back-23
	public void navigateBack() {
		driver.navigate().back();
	}
	//navigate to forward-24
	public void navigateForward() {
		driver.navigate().forward();
	}
	//navigate refresh-25
	public void navigateRefresh() {
		driver.navigate().refresh();
	}
	//JavasciptExcutorclick-26
	public void javaScriptExcutorclick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()",element);
	}
	//JavascriptExecutorsetAttribute-27
	public void jsExecutorsSetAtrribute(WebElement element,String datas) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','"+datas+"')", element);
	}
	//Javascriptexxcutor getattribute-28
	public String jsExecutorGetAttribute(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String script = executor.executeScript("arguments[0].getAttibute('value')", element).toString();
		return script;
	}
	//scroll down-29
	public void javaexecutorScrollDown(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)",element);
	}
	//scroll up-30
	public void javaexecutorScrollUp(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	//take screenshot-31
	public File screenShot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		return file;
	}
	//selectbyindex-32
	public void selectByindex(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	//selectbytext-33
	public void selectBytext(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	//selectbyvalue-34
	public void selectByvalue(WebElement element,String datas) {
		Select select = new Select(element);
		select.selectByValue(datas);
	}
	//selectbyall selected options-35
	public List selectalloptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> list = select.getAllSelectedOptions();
		return list;
	}
	//selectfirstoptions-36
	public WebElement selectFirstOptions(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;
	}
	//select get options-37
	public List SelectGetOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}
	//deselectByindex-38
	public void deselectByIndex(WebElement element,int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	//deselectByvalue-38
	public void deselectByValue(WebElement element,String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}
	//deselectBytext-39
	public void deselectBytext(WebElement element,String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}
	//deselectAll-40
	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}
	//Frame id-41
	public void frameId(String datas) {
		driver.switchTo().frame(datas);
	}
	//frameindex-42
	public void frameIndex(int index) {
		driver.switchTo().frame(index);
	}
	//frame webelement-43
	public void frameWebelement(WebElement element) {
		driver.switchTo().frame(element);
	}
	//Getwindow handle-44
	public String windowhandleById() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	//getWindowHandles-45
	public Set windowsHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
	
	public void implicitywait() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	public static void implicitywaits(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

	}
	
	public WebElement clear(WebElement element) {
		element.clear();
		return element;

	}
	
	public List<WebElement> elementsByID(String id) {
		
		List<WebElement> elements = driver.findElements(By.id(id));
		return elements;

	}
	
    public List<WebElement> elementsByName(String name) {
		
		List<WebElement> elements = driver.findElements(By.name(name));
		return elements;

	}
    
   public List<WebElement> elementsByClassName(String classs) {
		
		List<WebElement> elements = driver.findElements(By.className(classs));
		return elements;

	}
   
   public List<WebElement> elementsByXpath(String xpath) {
		
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		return elements;

	}
   
   public List<WebElement> elementsByTagName(String tagName) {
		
		List<WebElement> elements = driver.findElements(By.tagName(tagName));
		return elements;

	}


}
