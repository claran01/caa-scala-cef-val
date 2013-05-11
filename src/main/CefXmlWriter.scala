package main

import scala.collection.mutable.ListBuffer
import scala.xml.Comment
import scala.xml.Elem
import scala.xml.Node
import scala.xml.NodeSeq
import scala.xml.NodeBuffer
import scala.xml.Attribute
import scala.xml.Text
import scala.xml.Null

class CefXmlWriter {


	class El(tag: String, name: String) {
		val m_nodes = new NodeBuffer()

		def push(n: Node): Unit  = { m_nodes += n }

		def toXml(): NodeSeq = m_nodes

		def end_matches(i_tag: String, i_name: String): Unit = 
			if((tag == i_tag && name == i_name) == false)
				throw new IllegalArgumentException("start/end tags should match")
			else
				println("Ok")
	}


    
    val doc = new El("cef", "noname")
    var cur = doc

    def add_attr(k: String, v: String): Unit = { cur.push(<attr key={k} value={v} />) }
    def add_comment(s: String): Unit = { cur.push( new Comment(s) ) }
    
    def start_meta(n: String): Unit = { 
    	cur = new El("meta", n) 
    }

    def end_meta(n: String): Unit = { 
    	cur.end_matches("meta", n) 
    	doc.push(<meta name={n}> {cur.toXml} </meta>) 
    	cur = doc
    }

    def start_var(n: String): Unit = { 
    	cur = new El("var", n) 
    }

    def end_var(n: String): Unit = { 
    	cur.end_matches("var", n) 
    	doc.push(<var name={n}> {cur.toXml} </var>) 
    	cur = doc
    }
    
    def toXml: Elem = <cef>{doc.toXml}</cef>
    def dump(): Unit = println(toXml)

    def toPrettyXml: String = new scala.xml.PrettyPrinter(80,4).formatNodes(toXml)
    def dumpPrettyXml: Unit = println(toPrettyXml)

    def add_kv(k: String, v: String): Unit = {
    	if("START_META".compareToIgnoreCase(k) == 0)			start_meta(v) 
    	else if ("END_META".compareToIgnoreCase(k) == 0)		end_meta(v) 
    	else if ("START_VARIABLE".compareToIgnoreCase(k) == 0) 	start_var(v) 
    	else if ("END_VARIABLE".compareToIgnoreCase(k) == 0)	end_var(v) 
    	else 													add_attr(k,v) 
    }
}


