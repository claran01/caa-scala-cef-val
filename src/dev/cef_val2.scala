package main

import java.io.{FileInputStream,
                FileOutputStream,
                IOException,
                InputStreamReader}
import java.util.zip.GZIPInputStream

import scala.io.Source
import scala.util.control.Breaks.{break, breakable}

class CefSourceReaderXX(val i_path: String) {

    val m_fileInputStream = new FileInputStream(i_path)

    def getStream() = if (i_path.endsWith(".gz")) new GZIPInputStream(m_fileInputStream) else m_fileInputStream

    val m_source = Source.fromInputStream(getStream())

    def close() = m_source.close()
    
    def getLines(): Iterator[String] = m_source.getLines()
}


///////////////////////////////////////////////////////////////////////////////
//

class CefHeaderReaderXX(val i_path: String) {
    val m_cefSourceReader = new CefSourceReaderXX(i_path)
    //DATA_UNTIL=EOF
    val regexStr = "^[\\s]*([\\w]*)[\\s]*=[\\s]*(.*)[\\s]*$"
    val regexPattern = regexStr.r


    var W = new CefXmlWriter()

    breakable { 
        for(l <- m_cefSourceReader.getLines()) {

            if(l.matches(regexStr) == true) {
                val regexPattern(k, v) = l

                println(k + " ---------- "+ v)

                if("DATA_UNTIL".compareToIgnoreCase(k) == 0) break()
            }

            println("<-->")
        }
    }

    m_cefSourceReader.close();
}

