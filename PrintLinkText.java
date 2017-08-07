//To Print all link texts on the Google page
package printLinks
 
import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class FindAllLinks {
 
	public static void main(String[] args) {
		
	try{
 		String baseurl="https://google.com";

		//Browser Initialization
		WebDriver driver = new FirefoxDriver();

 		//Navigae to Google
		driver.get(baseurl);
 		
		//Collecting the Links on the webpage using List
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
 		
		//Print the no. of Links on the page
		System.out.println(links.size());
 		
		//Looping condition to access all links
		for (int i = 1; i<=links.size(); i=i+1)
 
		{
 			//Print Link Text
			System.out.println(links.get(i).getText());
 
		}
 
	   } catch (IOException e) {
		e.printStackTrace();
           }
   driver.close();
      }
}