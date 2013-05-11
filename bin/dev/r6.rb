require 'java'
require 'yaml'
 
 
##x import 'java.io.File'
import 'javax.xml.parsers.DocumentBuilder'
import 'javax.xml.parsers.DocumentBuilderFactory'
import 'javax.xml.parsers.ParserConfigurationException'
import 'javax.xml.transform.Transformer'
import 'javax.xml.transform.TransformerException'
import 'javax.xml.transform.TransformerFactory'
import 'javax.xml.transform.dom.DOMSource'
import 'javax.xml.transform.stream.StreamResult'

import 'org.w3c.dom.Attr'
import 'org.w3c.dom.Document'
import 'org.w3c.dom.Element'
 
# http:#//www.mkyong.com/java/how-to-create-xml-file-in-java-dom/
 
 
def test
	begin
 
		docFactory = DocumentBuilderFactory.newInstance()
		docBuilder = docFactory.newDocumentBuilder()

		puts("0")
		
		doc = docBuilder.newDocument()
		rootElement = doc.createElement("cef-pass")
		doc.appendChild(rootElement)
 
		puts("1")
 
 
		global_attributes = doc.createElement("global-attributes")
		rootElement.appendChild(global_attributes)

		attr = doc.createAttribute("eol")
		attr.setValue("$")
		global_attributes.setAttributeNode(attr)

		puts("2")
		
		
		end_of_line = doc.createElement("end-of-line")
		end_of_line.appendChild(doc.createTextNode("$$"))
		global_attributes.appendChild(end_of_line)


		include_headers = doc.createElement("include-headers")
		rootElement.appendChild(include_headers)
 
		puts("3")
 
 
		meta_data = doc.createElement("meta-data")
		rootElement.appendChild(meta_data)


		variables_data = doc.createElement("variables-data")
		rootElement.appendChild(variables_data)

		puts("10")

		
		transformerFactory = TransformerFactory.newInstance()
		transformer = transformerFactory.newTransformer()
		source = DOMSource.new(doc)


		result = StreamResult.new(java.lang.System.out)
		transformer.transform(source, result)
		
		f = java.io.File.new("C:/Dump/TEST.xml")
		result = StreamResult.new(f)
		transformer.transform(source, result)
 
		puts("File saved!")
 
	rescue Exception => e
		puts e.message
		puts e.backtrace.inspect
	end
	
	
end
 
test
 
