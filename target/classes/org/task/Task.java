package org.task;

public class Task  extends BaseClass
{
public static void main(String[] args) {
	browser("chromedriver");
	urllaunch("http://demo.guru99.com/test/drag_drop.html ");
	//urllaunch("https://www.facebook.com/");
  //  gettitle("title");
    maximize();
    timeout(10);
//    current("url");
//sendkeys(findElement("id", "email"), "kesava");
//WebElement txt= driver.findElement(By.id("email"));
//txt.sendKeys("kesava");
//getPageSource();
 //   quit();
//    close();
//System.out.println(getattribute(txt));
//    pageid();
 //   navigateto("https://ww.google.com/");
//  navigateback();
//  fresh();
//  forward();
dragAndDrop(findElement("id","credit2"), findElement("id","bank"));
}

}
