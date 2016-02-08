package by.epam.ta.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HighlightUtils {

	public void highlightElement(WebDriver webDr, WebElement element){
		String defColor=element.getCssValue("backgroundColor");
		((JavascriptExecutor)webDr).executeScript("arguments[0].style.backgroundColor = '"+"green"+"'",element);
		File pic = ((TakesScreenshot)webDr).getScreenshotAs(OutputType.FILE);
		File picPath=null;
		if (webDr instanceof  FirefoxDriver) {
			picPath=new File("./highlight_firefox.png");			
		} else if (webDr instanceof  ChromeDriver) {
			picPath=new File("./highlight_chrome.png");			
		} else {
			picPath=new File("./otherBrowser.png");
		};
	    try {
	    	FileUtils.copyFile(pic, picPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		((JavascriptExecutor)webDr).executeScript("arguments[0].style.backgroundColor = '"+defColor+"'",element);
	}
	
}