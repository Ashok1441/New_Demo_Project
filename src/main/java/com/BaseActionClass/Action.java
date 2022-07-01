package com.BaseActionClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.BaseClass.BaseTest;
import com.BaseClass.FileLib;
import com.UtilityClass.ExtentManager;
import com.UtilityClass.Log;



public class Action extends BaseTest {
	
	public static String getPageTitle() {
		
		String actualTitle = BaseTest.driver.getTitle();
		Log.info("Actual Page Title : "+actualTitle);
		ExtentManager.extent_Info("Actual Page Title : "+actualTitle);
		return actualTitle;
		
		
	}
	
	public static void assertEqualChar(String expectedTitle) throws Throwable {
		
		String actualPageTitle=getPageTitle();
		
		String expectedPageTitle = new FileLib().readProprertyData(Prop_Path, expectedTitle);
		Log.info("Expected Page Title : "+expectedPageTitle);
		ExtentManager.extent_Info("Expected Page Title : "+expectedPageTitle);
		
		Assert.assertEquals(actualPageTitle, expectedPageTitle, "Actual and Expected Titles are Mismatched");
		
		Log.info("Actual and Expected Titles both are Same");
		ExtentManager.extent_Info("Actual and Expected Titles both are Same");
	}
	public static void getUrl(String url) {
		Action.implicitWait(driver,20);
		Action.pageLoadTimeOut(driver,20);
		driver.get(url);
		Log.info("Given url is "+url);
		ExtentManager.extent_Info("Given url is "+url);
		driver.manage().window().maximize();
	}
	public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
		Log.info("Scrolled to given Element");
		ExtentManager.extent_Info("Scrolled to given Element");

	}
	
	public static void assertionText() {
		
	}
	public static void Actionsclass(WebDriver driver, WebElement ele) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();

	}
	
	
	public static boolean findElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			// System.out.println("Location not found: "+locatorName);
			flag = false;
		} finally {
			if (flag) {
				Log.info("Successfully Found element at");
				ExtentManager.extent_Info("Successfully element is found");

			} else {
				Log.info("Unable to locate the element");
				ExtentManager.extent_Info("Unable to locate the element");
			}
		}
		return flag;
	}
	
	public static boolean isDisplayed(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				Log.info("Element is Displayed");
				ExtentManager.extent_Info("Element is Displayed");
			} else {
				Log.info("Element is not Displayed");
				ExtentManager.extent_Info("Element is not Displayed");
			}
		} else {
			Log.info("Not displayed ");
			ExtentManager.extent_Info("Not Displayed");
		}
		return flag;
	}
	
	public static boolean isSelected(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isSelected();
			if (flag) {
				Log.info("Element is Selected");
				ExtentManager.extent_Info("Element is Selected");
			} else {
				Log.info("Element is not Selected");
				ExtentManager.extent_Info("Element is not Selected");
			}
		} else {
			Log.info("Element is not Selected");
			ExtentManager.extent_Info("Not selected ");
		}
		return flag;
	}
	
	public static boolean isEnabled(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isEnabled();
			if (flag) {
				Log.info("Element is Enabled");
				ExtentManager.extent_Info("Element is Enabled");
			} else {
				Log.info("Element is not Enabled");
				ExtentManager.extent_Info("Element is not Enabled");
			}
		} else {
			Log.info("Not Enabled ");
			ExtentManager.extent_Info("Not Enabled ");
		}
		return flag;
	}
	
	public static boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			// logger.info("Entered text :"+text);
			flag = true;
		} catch (Exception e) {
			Log.info("Location Not found");
			ExtentManager.extent_Info("Location Not found");
			flag = false;
		} finally {
			if (flag) {
//				Log.info("The given element is "+ele);
//				ExtentManager.extent_Info("The given element is "+ele);
				Log.info("The entered value is "+text);
				ExtentManager.extent_Info("The entered value is "+text);
				Log.info("Successfully entered the value");
				ExtentManager.extent_Info("Successfully entered the value");
			} else {
				Log.info("Unable to enter value");
				ExtentManager.extent_Info("Unable to enter value");
			}

		}
		return flag;
	}
	
	public static boolean selectBySendkeys(String value,WebElement ele) {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				
				Log.info("Select value from the DropDown");	
				ExtentManager.extent_Info("Select value from the DropDown");
			} else {
				
				Log.info("Not Selected value from the DropDown");
				ExtentManager.extent_Info("Not Selected value from the DropDown");
			}
		}
	}
	
	public static boolean selectByIndex(WebElement element, int index) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				Log.info("Option selected by Index");
				ExtentManager.extent_Info("Option selected by Index");
			} else {
				Log.info("Option not selected by Index");	
				ExtentManager.extent_Info("Option not selected by Index");
			}
		}
	}
	
	public static boolean selectByValue(WebElement element,String value) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				Log.info("Option selected by Value");	
				ExtentManager.extent_Info("Option selected by Value");
			} else {
				Log.info("Option not selected by Value");	
				ExtentManager.extent_Info("Option not selected by Value");
			}
		}
	}
	
	public static boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				Log.info("Option selected by VisibleText");
				ExtentManager.extent_Info("Option selected by VisibleText");
			} else {
				Log.info("Option not selected by VisibleText");
				ExtentManager.extent_Info("Option not selected by VisibleText");
			}
		}
	}
	
	public static boolean mouseHoverByJavaScript(WebElement ele) {
		boolean flag = false;
		try {
			WebElement mo = ele;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, mo);
			flag = true;
			return true;
		}

		catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				Log.info("MouseOver Action is performed");
				ExtentManager.extent_Info("MouseOver Action is performed");
			} else {
				Log.info("MouseOver Action is not performed");
				ExtentManager.extent_Info("MouseOver Action is not performed");
			}
		}
	}

	public static boolean JSClick(WebDriver driver, WebElement ele) throws Exception {
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			// driver.executeAsyncScript("arguments[0].click();", element);

			flag = true;

		}

		catch (Exception e) {
			throw e;

		} finally {
			if (flag) {
				Log.info("Click Action is performed");
				ExtentManager.extent_Info("Click Action is performed");
			} else if (!flag) {
				Log.info("Click Action is not performed");
				ExtentManager.extent_Info("Click Action is not performed");
			}
		}
		return flag;
	}
	
	public static boolean switchToFrameByIndex(WebDriver driver, int timeOut,int index) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(timeOut)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(index);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				Log.info("Frame with index \"" + index + "\" is selected");
				ExtentManager.extent_Info("Frame with index \"" + index + "\" is selected");
				System.out.println("Frame with index \"" + index + "\" is selected");
			} else {
				Log.info("Frame with index \"" + index + "\" is not selected");
				ExtentManager.extent_Info("Frame with index \"" + index + "\" is not selected");
			}
		}
	}
	
	public static boolean switchToFrameById(WebDriver driver,String idValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(idValue);
			flag = true;
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				Log.info("Frame with Id \"" + idValue + "\" is selected");
				ExtentManager.extent_Info("Frame with Id \"" + idValue + "\" is selected");
			} else {
				Log.info("Frame with Id \"" + idValue + "\" is not selected");
				ExtentManager.extent_Info("Frame with Id \"" + idValue + "\" is not selected");
			}
		}
	}
	
	public static boolean switchToFrameByName(WebDriver driver,String nameValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(nameValue);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				Log.info("Frame with Name \"" + nameValue + "\" is selected");
				ExtentManager.extent_Info("Frame with Name \"" + nameValue + "\" is selected");
			} else if (!flag) {
				Log.info("Frame with Name \"" + nameValue + "\" is not selected");
				ExtentManager.extent_Info("Frame with Name \"" + nameValue + "\" is not selected");
			}
		}
	}
	
	public static boolean switchToDefaultFrame(WebDriver driver) {
		boolean flag = false;
		try {
			driver.switchTo().defaultContent();
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				// SuccessReport("SelectFrame ","Frame with Name is selected");
			} else if (!flag) {
				// failureReport("SelectFrame ","The Frame is not selected");
			}
		}
	}
	
	public static void mouseOverElement(WebDriver driver,WebElement element) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				Log.info(" MouserOver Action is performed on given element");
				ExtentManager.extent_Info(" MouserOver Action is performed on given element");
			} else {
				Log.info(" MouserOver Action is not performed on given element");
				ExtentManager.extent_Info(" MouserOver Action is not performed on given element");
			}
		}
	}
	
	public static boolean moveToElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);
			// actions.moveToElement(driver.findElement(locator)).build().perform();
			actions.moveToElement(ele).perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean mouseover(WebDriver driver, WebElement ele, String locatorName) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(ele).perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	
	public static boolean draggable(WebDriver driver,WebElement source, int x, int y) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDropBy(source, x, y).build().perform();
			Thread.sleep(5000);
			flag = true;
			return true;

		} catch (Exception e) {
		
			return false;
			
		} finally {
			if (flag) {
				Log.info("Draggable Action is performed on \""+source+"\"");	
				ExtentManager.extent_Info("Draggable Action is performed on \""+source+"\"");			
			} else if(!flag) {
				Log.info("Draggable Action is not performed on \""+source+"\"");	
				ExtentManager.extent_Info("Draggable Action is not performed on \""+source+"\"");
			}
		}
	}
	
	public static boolean draganddrop(WebDriver driver,WebElement source, WebElement target) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDrop(source, target).perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				Log.info("DragAndDrop Action is performed");	
				ExtentManager.extent_Info("DragAndDrop Action is performed");
			} else if(!flag) {
				Log.info("DragAndDrop Action is not performed");	
				ExtentManager.extent_Info("DragAndDrop Action is not performed");
			}
		}
	}
	
	public static boolean slider(WebDriver driver,WebElement ele, int x, int y) {
		boolean flag = false;
		try {
			// new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
			// .perform();
			new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
			Thread.sleep(5000);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				Log.info("Slider Action is performed");
				ExtentManager.extent_Info("Slider Action is performed");
			} else {
				Log.info("Slider Action is not performed");
				ExtentManager.extent_Info("Slider Action is not performed");
			}
		}
	}
	public static boolean rightclick(WebDriver driver,WebElement ele) {
		boolean flag = false;
		try {
			Actions clicker = new Actions(driver);
			clicker.contextClick(ele).perform();
			flag = true;
			return true;
			// driver.findElement(by1).sendKeys(Keys.DOWN);
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				Log.info("RightClick Action is performed");
				ExtentManager.extent_Info("RightClick Action is performed");
			} else {
				Log.info("RightClick Action is not performed");
				ExtentManager.extent_Info("RightClick Action is not performed");
			}
		}
	}
	
	public static boolean switchWindowByTitle(WebDriver driver,String windowTitle, int count) {
		boolean flag = false;
		try {
			Set<String> windowList = driver.getWindowHandles();

			String[] array = windowList.toArray(new String[0]);

			driver.switchTo().window(array[count-1]);

			if (driver.getTitle().contains(windowTitle)){
				flag = true;
			}else{
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			//flag = true;
			return false;
		} finally {
			if (flag) {
				Log.info("Navigated to the window with title");
				ExtentManager.extent_Info("Navigated to the window with title");
			} else {
				Log.info("The Window with title is not Selected");
				ExtentManager.extent_Info("The Window with title is not Selected");
			}
		}
	}
	
	public static boolean switchToNewWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[1].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				Log.info("Window is Navigated with title");
				ExtentManager.extent_Info("Window is Navigated with title");				
			} else {
				Log.info("The Window with title: is not Selected");
				ExtentManager.extent_Info("The Window with title: is not Selected");
			}
		}
	}
	
	public static boolean switchToOldWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[0].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				Log.info("Focus navigated to the window with title");	
				ExtentManager.extent_Info("Focus navigated to the window with title");			
			} else {
				Log.info("The Window with title: is not Selected");	
				ExtentManager.extent_Info("The Window with title: is not Selected");	
			}
		}
	}
	
	public static int getColumncount(WebElement row) {
		List<WebElement> columns = row.findElements(By.tagName("td"));
		int a = columns.size();
		System.out.println(columns.size());
		for (WebElement column : columns) {
			System.out.print(column.getText());
			System.out.print("|");
		}
		return a;
	}
	
	public static int getRowCount(WebElement table) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int a = rows.size() - 1;
		return a;
	}
	
	public static boolean Alerts(WebDriver driver) {
		boolean presentFlag = false;
		Alert alert = null;

		try {
			// Check the presence of alert
			alert = driver.switchTo().alert();
			// if present consume the alert
			alert.accept();
			presentFlag = true;
		} catch (NoAlertPresentException ex) {
			// Alert present; set the flag

			// Alert not present
			ex.printStackTrace();
		} finally {
			if (!presentFlag) {
				Log.info("The Alert is handled successfully");
				ExtentManager.extent_Info("The Alert is handled successfully");		
			} else{
				Log.info("There was no alert to handle");
				ExtentManager.extent_Info("There was no alert to handle");	
			}
		}

		return presentFlag;
	}
	
	public static boolean launchUrl(WebDriver driver,String url) {
		boolean flag = false;
		try {
			driver.navigate().to(url);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				Log.info("Successfully launched \""+url+"\"");
				ExtentManager.extent_Info("Successfully launched \""+url+"\"");					
			} else {
				Log.info("Failed to launch \""+url+"\"");
				ExtentManager.extent_Info("Failed to launch \""+url+"\"");
				}
		}
	}
	
	public static boolean isAlertPresent(WebDriver driver) 
	{ 
		try 
		{ 
			driver.switchTo().alert(); 
			return true; 
		}   // try 
		catch (NoAlertPresentException Ex) 
		{ 
			return false; 
		}   // catch 
	}
	
	public static String getTitle(WebDriver driver) {
		boolean flag = false;

		String text = driver.getTitle();
		if (flag) {
			Log.info("Title of the page is: \""+text+"\"");
			ExtentManager.extent_Info("Title of the page is: \""+text+"\"");
		}
		return text;
	}
	
	public static String getCurrentURL(WebDriver driver)  {
		boolean flag = false;

		String text = driver.getCurrentUrl();
		if (flag) {
			Log.info("Current URL is: \""+text+"\"");
			ExtentManager.extent_Info("Current URL is: \""+text+"\"");
		}
		return text;
	}
	
	public static boolean click(WebElement ele, String locatorName) {
		boolean flag = false;
		try {
			ele.click();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
//				Log.info("The given element is "+ele);
//				ExtentManager.extent_Info("The given element is "+ele);
				Log.info("Able to click on \""+locatorName+"\"");
				ExtentManager.extent_Info("Able to click on \""+locatorName+"\"");
			} else {
				Log.info("Click Unable to click on \""+locatorName+"\"");
				ExtentManager.extent_Info("Click Unable to click on \""+locatorName+"\"");
			}
		}

	}
	
	public static void fluentWait(WebDriver driver,WebElement element,int timeOut) {
	    Wait<WebDriver> wait = null;
	    try {
	        wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(timeOut))
	        	    .pollingEvery(Duration.ofSeconds(timeOut))
	        	    .ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        element.click();
	    }catch(Exception e) {
	    }
	}
	
	public static void implicitWait(WebDriver driver,int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	public static void explicitWaitForElement(WebDriver driver, WebElement element,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void explicitWaitForTitle(WebDriver driver,String title ,int timeOut) {
		new WebDriverWait(driver, Duration.ofSeconds(timeOut)).until(ExpectedConditions.titleContains(title));

	}
	
	public static void pageLoadTimeOut(WebDriver driver,int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	
	}
	
	public static String screenShot(WebDriver driver, String filename) throws IOException {
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destiFile = new File(System.getProperty("user.dir")+".\\Screenshots\\"+filename+"_"+dateName+".png");
		FileUtils.copyFile(srcFile,destiFile );
		return destiFile.getAbsolutePath();
		
	}
	
	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}

}
