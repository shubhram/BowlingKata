package com.hcl.frame

import scala.collection.mutable.ListBuffer

trait Frames {
  def score():Int
  //def getFrame(i:Int):Frame
}
object Frames{
  def apply(i:Int): Frames = {
    Strike(i)
  }

  def apply(i:Int,j:Int): Frames =  {
    i==j match {
      case true => Spare(i,j)
      case _ => Normal(i,j)
    }
  }

  def apply(): Frames = {
    Invalid(0)
  }
  val buffer:ListBuffer[Frames] =new ListBuffer[Frames]
  def getFrameList(list:List[Int],index:Int): List[Frames] = {

    if(index<list.size) {

      list(index)==10 match {
        case true=> {
          buffer += this (list (index) )
          getFrameList (list, index + 1)
        }
        case _=> {
           if (index + 1 < list.size) {
            buffer += this (list (index), list (index + 1) )
            getFrameList (list, index + 2)
           }
        }
      }
    }


      buffer.toList
//    }
//    return null
  }
}

case class Invalid(i:Int) extends Frames {
  override def score(): Int = ???
}
case class Strike(i:Int) extends Frames {
  override def score(): Int = i
}

case class Normal(i1:Int,i2:Int) extends Frames {
  override def score(): Int = i1+i2
}


case class Spare(i1:Int,i2:Int) extends Frames {
  override def score(): Int = i1+i2
}

object Mainsss extends App{
//  val list:List[Int]=List.range(0,10)
//  var i=0;
//  i=i+1
//  for(i <-0;count=0 until list.size ) {
//
//    println(list(i))
//  }
  println(Frames.getFrameList(List(5,6,10,9,0),0))
}
