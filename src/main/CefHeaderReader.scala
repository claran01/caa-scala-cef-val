package main

import java.io.FileInputStream
import java.util.zip.GZIPInputStream

import scala.io.Source
import scala.util.control.Breaks.break
import scala.util.control.Breaks.breakable

class CefSourceReader(val i_path: String) {

    val m_fileInputStream = new FileInputStream(i_path)

    def getStream() = if (i_path.endsWith(".gz")) new GZIPInputStream(m_fileInputStream) else m_fileInputStream

    val m_source = Source.fromInputStream(getStream())

    def close() = m_source.close()
    
    def getLines(): Iterator[String] = m_source.getLines()
}


///////////////////////////////////////////////////////////////////////////////
//

class CefHeaderReader(val i_path: String) {
    val m_cefSourceReader = new CefSourceReader(i_path)
    val regexStr = "^[\\s]*([\\w]*)[\\s]*=[\\s]*(.*?)[\\s]*$"
    val regexCommentStr = "^[\\s]*!.*$"

    val regexPattern = regexStr.r

    var W = new CefXmlWriter()

    breakable { 
        for(l <- m_cefSourceReader.getLines()) {

            if(l.matches(regexStr) == true) {
                val regexPattern(k, v) = l

                W.add_kv(k, v)

                if("DATA_UNTIL".compareToIgnoreCase(k) == 0) break()
            }
            else if(l.matches(regexCommentStr) == true) {
                W.add_comment(l)
            }
            else if(l.length == 0) {
                // ignore
            }
            else {
                // malformed line => quit processing
                // throw CefMalformedHeaderLine
                throw new IllegalArgumentException("Unknown line type, Neither Attribute, Comment, or Empty Line -> " + l)
            }

            // println("<-->")
        }
    }

    W dumpPrettyXml

    val x = W toXml

    println("++++++++++++++")
    println(x)
    println("--------------")
    
    

//    println(x \\ "cef" \ "var")
    val vars = x \\ "var" \\ "@name"
    for (v <- vars) println(v)


    m_cefSourceReader.close();
}

