

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

class CefXmlWriter {
    
//    val doc = <cef />
    val doc = ListBuffer[Elem]()
    var cur = doc
    var el = ('a', 'no-name')

//    def add_attr(k: String, v: String): Unit = { println("add_attr", k,v) }
    def add_attr(k: String, v: String): Unit = { println("add_attr", k,v); cur += <attr key="{k}" value="{v}" /> }
    def add_comment(s: String): Unit = { println("add_comment", s); cur += <!-- {s} --> }

    def start_meta(n: String): Unit = { 
        cur = ListBuffer[Elem]()
    
//.        cur = <meta name="{n}" />    
//.        doc.append(cur)
    }
    def end_meta(n: String): Unit = { cur = doc }

    def start_var(n: String): Unit = { 
//.        cur = <var name="{n}" />    
//.        doc.append(cur)
    }
    def end_var(n: String): Unit = { cur = doc}

    
}


val W = new CefXmlWriter()

W.add_attr("FILE_NAME","C3_CP_EDI_EGD__20111009_V01.cef")
W.add_comment("! include EGD (DATASET) HEADER File for Cluster-3")





import scala.collection.mutable.ListBuffer
import scala.xml.Elem

var l = ListBuffer[Elem]()

for (i <- 1 to 10) { l += <a>{i}</a> }
//l += Map("t" -> "attr", "v" -> ListBuffer())


println(l)


var n1 = <abc>Hello, World</abc>
var n2 = <hello>{n1}</hello>


var ns = new scala.xml.NodeSeq()
ns += n1
ns += n2

println(ns)

//NodeSeq


















