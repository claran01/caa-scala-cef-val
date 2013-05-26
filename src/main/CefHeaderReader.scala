package main

import java.io.FileInputStream
import java.io.File
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

class CefIncludeContext {
    val m_include_folders = CmdLineArgs.getIncludeFolders
    var m_included_paths = Set[String]()
    var m_level_count = 0

    def error(i_message: String): Unit = throw new IllegalArgumentException("CefIncludeContext: " + i_message) 

    def include_this(i_filename: String): String = {
        var l_path: String = null;
        val l_folders_it = m_include_folders.iterator

        while(l_path == null && l_folders_it.hasNext)
        {
            val p: String = l_folders_it.next + '/' + i_filename

            if(m_included_paths.contains(p) == false) {
                val f = new File(p)

                if(f.exists && f.isFile) {
                    m_included_paths += p
                    l_path = p
                }
            }
            else {
                error("Duplicate include file deteceted -> " + p)
            }
        }

        if(l_path == null) error("Include file NOT found -> " + i_filename)
        else               println("Found:", l_path)

        l_path
    }

    def inc_level: Unit = m_level_count+=1
    def dec_level: Unit = m_level_count-=1
} 


class CefHeaderReader(val i_path: String,
                      val i_context: CefIncludeContext) {
    val m_cefSourceReader = new CefSourceReader(i_path)
    val regexStr = "^[\\s]*([\\w]*)[\\s]*=[\\s]*(.*?)[\\s]*$"
    val regexCommentStr = "^[\\s]*!.*$"

    val m_context = if(i_context == null) new CefIncludeContext else i_context

    val regexPattern = regexStr.r

    var W = new CefXmlWriter()

    def include_ceh(i_filename: String): Unit = {

        println("include -> ", i_filename)
        // check unique paths
        // new CefHeader(l_path, includeContext)
        // val H = new CefHeaderReader(newpath, cx)
        // W += H.W

        val l_path = m_context.include_this(i_filename)
        var R = new CefHeaderReader(l_path, m_context)

        W.add_xml(R.toXmlInner)
    }


    def unquote(v: String): String = {
        val l = v.length
        
        if(l >= 2 && v.charAt(0) == '\"' && v.charAt(l-1) == '\"') v.substring(1,l-1) else v
    }

    breakable { 
        for(l <- m_cefSourceReader.getLines()) {

            if(l.matches(regexStr) == true) {
                val regexPattern(k, v) = l

                W.add_kv(k, v)

                if("DATA_UNTIL".compareToIgnoreCase(k) == 0) break()
                else if("include".compareToIgnoreCase(k) ==0) include_ceh(unquote(v))
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

    def toXml = W toXml
    def toXmlInner = W toXmlInner

    def dumpPrettyXml = W dumpPrettyXml

    def dump: Unit = {
        dumpPrettyXml

        val x = toXml

        println("++++++++++++++")
        println(x)
        println("--------------")
        
    //    println(x \\ "cef" \ "var")
        val vars = x \\ "var" \\ "@name"
        for (v <- vars) println(v)
    }

    // dump

    m_cefSourceReader.close();
}

