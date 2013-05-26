package main


object CmdLineArgs {

    var m_include_folders = List(
    	"/home/spw/Library/__CEF_CEH_SAMPLES__/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF",
    	"/home/spw/Library/__CEF_CEH_SAMPLES__/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EFW",
    	"/home/spw/Library/__CEF_CEH_SAMPLES__/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EDI",
    	"/home/spw/Library/__CEF_CEH_SAMPLES__/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS"
    	    	)

//    def getIncludeFolders(): List[String] = { m_include_folders }
    def getIncludeFolders: List[String] =  m_include_folders 

}

