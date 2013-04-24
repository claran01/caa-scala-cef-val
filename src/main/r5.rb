require 'java'
require 'yaml'
 
 
import 'java.io.File'
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

		
		doc = docBuilder.newDocument()
		rootElement = doc.createElement("cef-pass")
		doc.appendChild(rootElement)
 
 
 
		global_attributes = doc.createElement("global-attributes")
		rootElement.appendChild(global_attributes)

		Attr attr = doc.createAttribute("eol")
		attr.setValue("$")
		global_attributes.setAttributeNode(attr)

		end_of_line = doc.createElement("end-of-line")
		end_of_line.appendChild(doc.createTextNode("$$"))
		global_attributes.appendChild(firstname)


		include_headers = doc.createElement("include-headers")
		rootElement.appendChild(include_headers)
 
 
 
		meta_data = doc.createElement("meta-data")
		rootElement.appendChild(meta_data)


		variables_data = doc.createElement("variables-data")
		rootElement.appendChild(meta_data)
 
 
 
##x 		#// set attribute to staff element
##x 		Attr attr = doc.createAttribute("id")
##x 		attr.setValue("1")
##x 		staff.setAttributeNode(attr)
##x  
##x 		#// shorten way
##x 		#// staff.setAttribute("id", "1")
##x  
##x 		#// firstname elements
##x 		Element firstname = doc.createElement("firstname")
##x 		firstname.appendChild(doc.createTextNode("yong"))
##x 		staff.appendChild(firstname)
##x  
##x 		#// lastname elements
##x 		Element lastname = doc.createElement("lastname")
##x 		lastname.appendChild(doc.createTextNode("mook kim"))
##x 		staff.appendChild(lastname)
##x  
##x 		#// nickname elements
##x 		Element nickname = doc.createElement("nickname")
##x 		nickname.appendChild(doc.createTextNode("mkyong"))
##x 		staff.appendChild(nickname)
##x  
##x 		#// salary elements
##x 		Element salary = doc.createElement("salary")
##x 		salary.appendChild(doc.createTextNode("100000"))
##x 		staff.appendChild(salary)


 
		transformerFactory = TransformerFactory.newInstance()
		transformer = transformerFactory.newTransformer()
		source = DOMSource.new(doc)
		f = File.new("C:\\dump\TEST.xml")
		result = StreamResult.new(f)
 
		#// Output to console for testing
		#// 
		
		result = StreamResult.new(System.out)
 
		transformer.transform(source, result)
 
		System.out.println("File saved!")
 
	rescue
		puts "An error occurred"
	end
end
 
test
 
 
#x	  } catch (ParserConfigurationException pce) {
#x		pce.printStackTrace()
#x	  } catch (TransformerException tfe) {
#x		tfe.printStackTrace()
#x	  }