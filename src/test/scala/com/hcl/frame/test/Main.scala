package com.hcl.frame.test

import com.hcl.frame.Frame

object Main extends App {

  val f: List[Frame] = Frame.getTotalStat2(List(7, 2, 5, 5, 3, 0, 10, 2, 4, 10,4))
  println(f)
}
