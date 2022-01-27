package org.task;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver browser(String browser) {
		if (browser.equals("chromedriver")) {
			WebDriverManager.chromedriver().setup();
			return driver = new ChromeDriver();
		} else if (browser.equals("firefoxdriver")) {
			WebDriverManager.firefoxdriver().setup();
			return driver = new FirefoxDriver();
		} else if (browser.equals("edgedriver")) {
			WebDriverManager.edgedriver().setup();
			return driver = new EdgeDriver();
		}
		return driver;
	}

	public static void urllaunch(String url) {
		driver.get(url);

	}

	public static void btnclick(WebElement e) {
		e.click();
	}

	public static  String currenturl() {
		return driver.getCurrentUrl();

	}

	public static void gettitle(String title) {
		System.out.println(driver.getTitle());

	}

	public static void maximize() {
		driver.manage().window().maximize();

	}

	public static void timeout(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public static WebElement findElement(String locator, String value) {
		WebElement e = null;
		if (locator.equals("id")) {
			e = driver.findElement(By.id(value));

		} else if (locator.equals("name")) {
			e = driver.findElement(By.name(value));
		} else if (locator.equals("xpath"))
			e = driver.findElement(By.xpath(value));
		else if (locator.equals("tagname")) {
			e = driver.findElement(By.tagName(value));
		}
		return e;
	}

	public static String getattribute(WebElement e) {
		String at = e.getAttribute("value");
		return at;
	}

	public static void sendkeys(WebElement e, String value, Keys enter) {
		e.sendKeys(value,enter);
	}
	public static void sendkeys(WebElement e, String value) {
		e.sendKeys(value);
	}


	public static void quit() {
		driver.quit();
	}

	public static void close() {
		driver.close();
	}

	public static void getPageSource() {

		System.out.println(driver.getPageSource());

	}

	public static void pageid() {
		System.out.println(driver.getWindowHandle());

	}

	public static void navigateto(String e) {
		driver.navigate().to(e);

	}

	public static void navigateback() {
		driver.navigate().back();

	}

	public static void fresh() {
		driver.navigate().refresh();

	}

	public static void forward() {
		driver.navigate().forward();
	}

	public static void windows() {
		String c = driver.getWindowHandle();
		Set<String> all = driver.getWindowHandles();
		for (String x : all) {
			if (!c.equals(x)) {
				driver.switchTo().window(x);
			}

		}

	}
	// Actions

	public static void dragAndDrop(WebElement src, WebElement des) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, des).perform();
	}

	public static void contextclik(WebElement e) {
		Actions a = new Actions(driver);
		a.contextClick(e).perform();
	}

	public static void doubleclick(WebElement e) {
		Actions a = new Actions(driver);
		a.doubleClick(e).perform();
	}

	public static void movetoelement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();

	}

	public static void click1(WebElement e) {
		Actions a = new Actions(driver);
		a.click(e).perform();
	}

	// Select
	public static void selectbyIndex(WebElement e, int index) {
		Select s = new Select(e);
		s.selectByIndex(index);

	}

	public static void selectbyvalue(WebElement e, int i) {

		Select s = new Select(e);
		s.selectByIndex(i);
	}

	public static void selectbyvisibletext(WebElement e, String value) {

		Select s = new Select(e);
		s.selectByVisibleText(value);

	}
public static void getoptions(WebElement e) {
		Select s = new Select(e);
		List<WebElement> options = s.getOptions();
		int size = options.size();
System.out.println(size);

	}
public static void ismultiple(WebElement e) {
Select s= new Select(e);
s.isMultiple();
}
public static void screenshot(String name) throws IOException {
TakesScreenshot tk= (TakesScreenshot) driver;
File src= tk.getScreenshotAs(OutputType.FILE);
File des = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshot\\"+name+".jpg");
FileUtils.copyFile(src, des);
}

}