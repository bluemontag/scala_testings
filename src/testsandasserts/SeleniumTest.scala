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

import org.scalatest.FunSpec
import java.util.concurrent.TimeUnit
import org.scalatest.time.SpanSugar
import org.scalatest.ParallelTestExecution
import org.openqa.selenium.WebDriver
import org.scalatest.time.Span
import org.scalatest.time.Seconds
import org.scalatest.exceptions.TestFailedException
import org.scalatest.concurrent.Eventually._

class SeleniumTest extends FlatSpec with Matchers with WebBrowser {

  System setProperty ("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe")

  implicit val webDriver: WebDriver = new FirefoxDriver

  "The Google page" should "have the correct title" in {
    go to ("http://www.google.com.ar")

    click on name("q") // to lookup by name "q"
    textField("q").value = "María Emilia Lucidi"
    submit()

    // Google's search is rendered dynamically with a JavaScript AJAX call.

    eventually(timeout(Span(10, Seconds))) {
      pageTitle should be("María Emilia Lucidi - Buscar con Google")
    }

    Thread.sleep(3000) //espero 3 segundos

    quit
  }
}
