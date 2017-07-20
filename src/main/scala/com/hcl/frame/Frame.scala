package com.hcl.frame

import scala.collection.mutable.ListBuffer

//case class Frame(hit1: Int, hit2: Int)

case  class Frame(pins:Int)

object Frame {


  val tmpBuffer = new ListBuffer[Int]
  val maxBowlHit = 10
  val noOfTry = 2
  def getTotalStat2(l: List[Int]): List[Frame] = {

    val output: ListBuffer[Frame] = new ListBuffer[Frame]
    l.foreach(x => {
      if (x == maxBowlHit) {
        output += Frame(x)
      }
      else {
        var frm = getFrame(x)
        if (frm != null) {
          output += frm
        }
      }
    }
    )
    output.toList
  }

  def getFrame(b: Int): Frame = {

    if (tmpBuffer.size==noOfTry-1) {

      var sum=b
      var count=0
      for(count <-0 to noOfTry-2) {
        sum=sum+tmpBuffer.remove(0)

      }

      //println(tmpBuffer.nonEmpty)
      Frame(sum)

    }
    else {

      tmpBuffer += b
      null
    }
  }
}

