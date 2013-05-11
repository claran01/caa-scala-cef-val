package test

import main._

object Test_CefHeaderReader extends App {
    val CEF_TEST_DATA_ROOT = "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF"
    //val CEF_TEST_DATA_ROOT = "C:/work.dev.scala/caa-scala-cef-val/src/test/data/CEF"

    //val l_path = CEF_TEST_DATA_ROOT + "/EDI/C3_CP_EDI_EGD__20111009_V01.cef.gz";
    val l_path = CEF_TEST_DATA_ROOT + "/EDI/C3_CP_EDI_EGD__20111009_V01.cef";

    val l_headerReader = new CefHeaderReader(l_path)
    // val l_cefSourceReader = new CefSourceReader(l_path)
    // //DATA_UNTIL=EOF
}
