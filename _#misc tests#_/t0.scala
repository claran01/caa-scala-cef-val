//x 
//x 
//x val m = Map(1 -> "foo", 2 -> "bar")
//x 
//x m map { case (k,v) => s"$k is $v" }
//x 
//x m map println
//x 
//x 
//x 
//x 
//x 	
//x val nums = List(1, 2, 3, 4, 5)
//x val sum = nums.foldLeft(0) { (total, n) =>
//x 
//x   println(total, n)
//x   
//x   total + n
//x }
//x 
//x println("\n\n---");
//x 
//x println((1 to 100).foldLeft(0) { (total, n) =>   total + n})
//x 
//x 
//x println("\n\n---");
//x 
//x val names = List("Daniel", "Chris", "Joseph")
//x val str = names.reduceLeft[String] { (acc, n) =>
//x   acc + ", " + n
//x }
//x  
//x println(str)
//x 
//x 
//x 
//x 
//x println("\n\n---");
//x 
//x val nums = (1 to 100)
//x val n = nums.reduceLeft[Int] { (acc, n) =>   acc + n }
//x  
//x println(n)
//x //x 


//def add_attr(k: String, v: String): Unit = { println("add_attr", k,v); cur += <attr key="{k}" value="{v}"></attr> }

import scala.collection.mutable.ListBuffer
import scala.xml.Elem
import scala.xml.Node

var m1 = ListBuffer[Node]()

//x for (i <- 1 to 10) { m1 += <a key={i} value={i+3}>{i}</a> }
for (i <- 1 to 10) { m1 += <a key= "{i}" >{i}</a> }
for (m <- m1) { println(m) }


println("\n----------------------------------------------\n")


//var doc = ListBuffer[Node]()


var doc = <cef><meta name="123">{for (m <- m1) yield m} </meta></cef>
//x var doc = <cef><meta name="123"></meta></cef>

println(doc)
