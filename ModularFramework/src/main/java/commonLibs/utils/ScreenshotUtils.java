package commonLibs.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	
	private TakesScreenshot screenshot;

	public ScreenshotUtils(WebDriver driver) {
	   screenshot = (TakesScreenshot)driver;
	}

	public void captureScreenshot(String filename) throws Exception {
	   filename= filename.trim();
	   File imgFile, tmpFile;
	   imgFile = new File(filename);
	   
	    File directory = imgFile.getParentFile();
	    if (directory != null && !directory.exists()) {
	        directory.mkdirs();
	    }
	   
	   if(imgFile.exists()) {
	       throw new Exception("file Already Exists");
	   }
	   
	   tmpFile = screenshot.getScreenshotAs(OutputType.FILE);
	   FileUtils.moveFile(tmpFile, imgFile);
	}

}
