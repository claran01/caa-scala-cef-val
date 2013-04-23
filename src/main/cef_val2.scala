import java.io.{BufferedReader, 
                FileInputStream,
                FileOutputStream,
                IOException,
                InputStreamReader}
import java.util.zip.GZIPInputStream

import scala.io.Source
import scala.util.control.Breaks.{break, breakable}

class CefSourceReader(val i_path: String) {

    val m_fileInputStream = new FileInputStream(i_path)

    // def getStream(): = if (i_path.endsWith(".gz")) new GZIPInputStream(m_fileInputStream) else m_fileInputStream
    def getStream() = if (i_path.endsWith(".gz")) new GZIPInputStream(m_fileInputStream) else m_fileInputStream

    val m_source = Source.fromInputStream(getStream())

    def close() = m_source.close()
    
    def getLines(): Iterator[String] = m_source.getLines()
//    val lineIterator = source.getLines
}



//val l_path = "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111009_V01.cef.gz";
val l_path = "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111009_V01.cef";
val l_cefSourceReader = new CefSourceReader(l_path)

//DATA_UNTIL=EOF

breakable {
    for(l <- l_cefSourceReader.getLines()) {
        if(l.matches("^[\\s]*DATA_UNTIL(.*)$") == true) break()
        println(l)
    }
}


l_cefSourceReader.close();

