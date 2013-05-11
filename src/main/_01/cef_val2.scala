import java.io.{FileInputStream,
                FileOutputStream,
                IOException,
                InputStreamReader}
import java.util.zip.GZIPInputStream

import scala.io.Source
import scala.util.control.Breaks.{break, breakable}

class CefSourceReader(val i_path: String) {

    val m_fileInputStream = new FileInputStream(i_path)

    def getStream() = if (i_path.endsWith(".gz")) new GZIPInputStream(m_fileInputStream) else m_fileInputStream

    val m_source = Source.fromInputStream(getStream())

    def close() = m_source.close()
    
    def getLines(): Iterator[String] = m_source.getLines()
}


///////////////////////////////////////////////////////////////////////////////
//



val CEF_TEST_DATA_ROOT = "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF"
//val CEF_TEST_DATA_ROOT = "C:/work.dev.scala/caa-scala-cef-val/src/test/data/CEF"

//val l_path = CEF_TEST_DATA_ROOT + "/EDI/C3_CP_EDI_EGD__20111009_V01.cef.gz";
val l_path = CEF_TEST_DATA_ROOT + "/EDI/C3_CP_EDI_EGD__20111009_V01.cef";


val l_cefSourceReader = new CefSourceReader(l_path)
//DATA_UNTIL=EOF







val regexStr = "^[\\s]*([\\w]*)[\\s]*=[\\s]*(.*)[\\s]*$"
val regexPattern = regexStr.r



    // W.add_attr("FILE_NAME","C3_CP_EDI_EGD__20111009_V01.cef")
    // W.add_comment("! include EGD (DATASET) HEADER File for Cluster-3")

    // W.start_meta("METANAME")
    // W.add_attr("M1NAME","M1 VALUE")
    // W.add_comment("! M1 COMMENT GOES HERE")
    // W.end_meta("METANAME")

var W = new CefXmlWriter()


breakable {
    for(l <- l_cefSourceReader.getLines()) {
        if(l.matches("^[\\s]*DATA_UNTIL(.*)$") == true) break()
        //println(l)


        if(l.matches(regexStr) == true) {
            val regexPattern(k, v) = l

            println(k + " ---------- "+ v)
        }
    }
}


l_cefSourceReader.close();

