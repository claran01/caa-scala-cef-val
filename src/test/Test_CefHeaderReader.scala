package test

import main._

object Test_CefHeaderReader extends App {
    val l_path = CmdLineArgs.CEF_TEST_DATA_ROOT + "/EDI/C3_CP_EDI_EGD__20111009_V01.cef";

    val l_headerReader = new CefHeaderReader(l_path, null)

    l_headerReader dump
}

