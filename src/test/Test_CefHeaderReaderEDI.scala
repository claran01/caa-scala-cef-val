package test

import main._

object Test_CefHeaderReaderEDI extends App {
    val CEF_TEST_DATA_ROOT = "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF"


    // relatively complicated
    val l_pathEDI = CEF_TEST_DATA_ROOT + "/RESOLVED/EDI" + "/C3_CP_EDI_EGD__20111009_000000_20111010_000000_V121103.cef"


    val l_headerReader = new CefHeaderReader(l_pathEDI)
}

