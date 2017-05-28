package autos

import java.io._


class Car (milesPerGallon:Int, gallonsPerTank:Int) {
  var mpg: Int = milesPerGallon
  var gpt: Int = gallonsPerTank
  var mpt: Int = 0
  
  def milesPerTank() {
    mpt = mpg * gpt
    println("Number of miles per tank: "+mpt)
  }
}

object Volvo {
  def main(args: Array[String]) {
    val volvo =  new Car(40, 18)
    volvo.milesPerTank()
  }
}