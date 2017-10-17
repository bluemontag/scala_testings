package testsandasserts

import org.scalatest._

import org.scalatest.matchers._
import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.{ By, WebElement }
//import org.openqa.selenium.htmlunit.HtmlUnitDriver
import scala.collection.JavaConversions._
import org.scalatest.selenium.Firefox
import org.openqa.selenium.firefox._

class ArasSeleniumTest extends FlatSpec with Matchers with WebBrowser {

  System setProperty ("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe")
  
  implicit val webDriver: WebDriver = new FirefoxDriver
  
  "The Google page" should "have the correct title" in {
    go to ("http://www.google.com.ar")
    pageTitle should be ("Google")
    
    webDriver quit
  }
}
