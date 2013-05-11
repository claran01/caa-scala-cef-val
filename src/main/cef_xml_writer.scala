//<?xml version="1.0" encoding="UTF-8" ?>

val doc2 = 
<cef>
	<attr key="FILE_NAME" value="C3_CP_EDI_EGD__20111009_V01.cef" />
	<attr key="FILE_FORMAT_VERSION" value="CEF-2.0" />
	<!-- !  -->
	<meta name="LOGICAL_FILE_ID">
		<attr key="ENTRY" value="C3_CP_EDI_EGD__20111009_V01" />
	</meta>
	<!-- !  -->
	<meta name="VERSION_NUMBER">
		<attr key="ENTRY" value="01" />
	</meta>
	<!-- !  -->
	<meta name="FILE_TIME_SPAN">
		<attr key="VALUE_TYPE" value="ISO_TIME_RANGE" type="" />
		<attr key="ENTRY" value="2011-10-09T00:00:00Z/2011-10-10T00:00:00Z" type="" />
	</meta>
	<!-- !  -->
	<meta name="FILE_TIME_SPAN">
		<attr key="VALUE_TYPE" value="ISO_TIME_RANGE" type="" />
		<attr key="ENTRY" value="2011-10-09T00:00:00Z/2011-10-10T00:00:00Z" type="" />
	</meta>
	<!-- !  -->
	<meta name="GENERATION_DATE">
		<attr key="VALUE_TYPE" value="ISO_TIME" type="" />
		<attr key="ENTRY" value="2012-04-11T15:57:15Z" type="" />
	</meta>
	<!-- !  -->
	<!-- ! include EGD (DATASET) HEADER File for Cluster-3" -->
	<!-- ! with variable definitions, metadata_type and _version" -->
	<!-- !  -->
	<attr key="include" value="C3_CH_EDI_EGD_DATASET" />
	<!-- !  -->
	<attr key="DATA_UNTIL" value="EOF" />
	<!-- !  -->
</cef>

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

    	// if("START_META".compareToIgnoreCase(k) == 0)			{ start_meta(v) }
    	// else if ("END_META".compareToIgnoreCase(k) == 0)		{ end_meta(v) }
    	// else if ("START_VARIABLE".compareToIgnoreCase(k) == 0) 	{ start_var(v) }
    	// else if ("END_VARIABLE".compareToIgnoreCase(k) == 0)	{ end_var(v) }
    	// else 													{ add_attr(k,v) }

    }

}


// TESTS
// ............................................................................

def test_001(): Unit =
{
	try {

		var W = new CefXmlWriter()

		W.add_attr("FILE_NAME","C3_CP_EDI_EGD__20111009_V01.cef")
		W.add_comment("! include EGD (DATASET) HEADER File for Cluster-3")

		W.start_meta("METANAME")
		W.add_attr("M1NAME","M1 VALUE")
		W.add_comment("! M1 COMMENT GOES HERE")
		W.end_meta("METANAME")

		W.add_attr("F2","THIS is the value of f2")
		W.add_comment("! another top level comment") 

		W dumpPrettyXml

	} catch {
		case _: IllegalArgumentException => println("Execption: start/end tags miss-match")
	}

}


def test_002(): Unit =
{
	try {

		var W = new CefXmlWriter()

		W.add_kv("FILE_NAME","C3_CP_EDI_EGD__20111009_V01.cef")
		W.add_comment("! include EGD (DATASET) HEADER File for Cluster-3")

		W.add_kv("START_META", "METANAME")
		W.add_kv("M1NAME","M1 VALUE")
		W.add_comment("! M1 COMMENT GOES HERE")
		W.add_kv("END_META","METANAME")

		W.add_kv("F2","THIS is the value of f2")
		W.add_comment("! another top level comment") 


		W.add_kv("START_VARIABLE", "VARIABLENAME")
		W.add_kv("V1NAME","V1 VALUE")
		W.add_comment("! V1 COMMENT GOES HERE")
		W.add_kv("END_VARIABLE","VARIABLENAME")

		W dumpPrettyXml

	} catch {
		case _: IllegalArgumentException => println("Execption: start/end tags miss-match")
	}

}


//test_001()
test_002()

