caa-scala-cef-val
=================

A scala based cef (Cluster Exchange Format) validation command line app.


Command Line Options
====================


./app-name -I /include/path/ceh-heaaders-#1 -I /include/path/ceh-heaaders-#2 ... /path-to-cef-filename.cef


    -toXML          // convert metadata to XML
    -metaOnly       // skip data


Todo list
=========


- parse header data of main cef file
- parse referenced ceh files

- check/validate header meta data
	- filename format
	- correct names
	- data types
	- enumerated types
	- more to follow
	
- read data records
	- check timestamps
	- variable data types
	- fill-vals
	- number of variables
more