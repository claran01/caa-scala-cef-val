package test

import main._

object Test_CefXmlWriter extends App {

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

	} 
	catch {
		case _: IllegalArgumentException => println("Execption: start/end tags miss-match")
	}	
}