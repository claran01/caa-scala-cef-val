
		// FILE_NAME="C3_CP_EDI_EGD__20111009_V01.cef"
		// FILE_FORMAT_VERSION="CEF-2.0"
		// !
		// START_META = LOGICAL_FILE_ID
		//  ENTRY = "C3_CP_EDI_EGD__20111009_V01"
		// END_META = LOGICAL_FILE_ID
		// !
		// START_META = VERSION_NUMBER
		//  ENTRY = "01"
		// END_META = VERSION_NUMBER
		// !
		// START_META = FILE_TIME_SPAN
		//  VALUE_TYPE = ISO_TIME_RANGE
		//  ENTRY = 2011-10-09T00:00:00Z/2011-10-10T00:00:00Z
		// END_META = FILE_TIME_SPAN
		// !
		// START_META = GENERATION_DATE
		//  VALUE_TYPE = ISO_TIME
		//  ENTRY = 2012-04-11T15:57:15Z
		// END_META = GENERATION_DATE
		// !
		// START_META = FILE_CAVEATS
		//  ENTRY = "CAA_EDITOF_V1_04  2011-04-04T10:30:00Z"
		// END_META = FILE_CAVEATS
		// !
		// ! include EGD (DATASET) HEADER File for Cluster-3
		// ! with variable definitions, metadata_type and _version
		// include="C3_CH_EDI_EGD_DATASET.ceh"
		// !
		// DATA_UNTIL=EOF
		// !

import java.util.regex.Matcher
import java.util.regex.Pattern

val p_sm = Pattern.compile("START_META", Pattern.CASE_INSENSITIVE);
val p_em = Pattern.compile("END_META", Pattern.CASE_INSENSITIVE);

val p_sv = Pattern.compile("START_VARIABLE", Pattern.CASE_INSENSITIVE);
val p_ev = Pattern.compile("END_VARIABLE", Pattern.CASE_INSENSITIVE);


def check_match(v: (String, String)): Unit = {
// 	case "START_META" => println("FOUND START_META")
// 	case "END_META" => println("FOUND END_META")
// 	case p_sm
// //ase  compareToIgnoreCase(String str) 
// 	case _ => println("NOT FOUND")

	val s = 
	if(p_sm.matcher(v._1).matches() == true) 	   "START_META" 
	else if(p_em.matcher(v._1).matches() == true)  "END_META"
	else if(p_sv.matcher(v._1).matches() == true)  "START_VARIABLE"
	else if(p_ev.matcher(v._1).matches() == true)  "END_VARIABLE"
	else  "NO MATCH"

	println(s)
}

check_match(("START_META", "VERSION_NUMBER"))
check_match(("END_xmETA", "VERSION_NUMBER"))

