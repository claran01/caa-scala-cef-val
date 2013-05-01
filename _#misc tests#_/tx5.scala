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


class El(tag: String, name: String) {
	val m_nodes = new NodeBuffer()

	def push(n: Node): Unit  = { m_nodes += n }

//	def toXml(): Node = <tag>{m_nodes}</tag> 
	def toXml(): NodeSeq = m_nodes
}


class CefXmlWriter {
    
    val doc = new El("cef", "noname")
    var cur = doc

    def add_attr(k: String, v: String): Unit = { cur.push(<attr key={k} value={v} />) }
//  def add_comment(s: String): Unit = { cur.push(<comment>{s}</comment>) }
    def add_comment(s: String): Unit = { cur.push( new Comment(s) ) }
    
    def start_meta(n: String): Unit = { cur = new El("meta", n) }
    def end_meta(n: String): Unit = { doc.push(<meta name={n}> {cur.toXml} </meta>) }

    def start_var(n: String): Unit = { cur = new El("var", n) }
    def end_var(n: String): Unit = { doc.push(<var name={n}> {cur.toXml} </var>) }
    
    def toXml: Elem = <cef>{doc.toXml}</cef>
    def dump(): Unit = println(toXml)

}


var W = new CefXmlWriter()

W.add_attr("FILE_NAME","C3_CP_EDI_EGD__20111009_V01.cef")
W.add_comment("! include EGD (DATASET) HEADER File for Cluster-3")

W.start_meta("METANAME")
W.add_attr("M1NAME","M1 VALUE")
W.add_comment("! M1 COMMENT GOES HERE")
W.end_meta("METANAME")

//W.dump

val pp = new scala.xml.PrettyPrinter(80,4);
println(pp.formatNodes(W.toXml))

