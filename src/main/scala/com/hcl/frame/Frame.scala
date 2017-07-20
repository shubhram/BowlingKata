package com.hcl.frame

import scala.collection.mutable.ListBuffer

//case class Frame(hit1: Int, hit2: Int)

case  class Frame(pins:Int)

object Frame {


  val tmpBuffer = new ListBuffer[Int]
  def getTotalStat2(l: List[Int]): List[Frame] = {

    val maxBowlHit = 10
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
    if (tmpBuffer.nonEmpty) {
      val one = tmpBuffer.remove(0)
      //println(tmpBuffer.nonEmpty)
      Frame(one+ b)

    }
    else {
      tmpBuffer += b
      null
    }
  }
}

