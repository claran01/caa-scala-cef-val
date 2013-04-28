


val when = "at the begining"

val doc = <html><head><title>To Begin {when}</title></head><body><p>Hello, World!</p></body></html>

println(doc)



val list = <dl><dt>Java</dt><dd>Gosling</dd><dt>Scala</dt><dd>Odersky</dd></dl>
val languages = list \ "dt"

println("...")
println(languages)

for(l <- languages) println(l)




//<?xml version="1.0" encoding="UTF-8" ?>

val doc2 = 
<cef>
	<attr key="FILE_NAME" value="C3_CP_EDI_EGD__20111009_V01.cef" />
	<attr key="FILE_FORMAT_VERSION" value="CEF-2.0" />
	<!-- !  -->
	<meta name="LOGICAL_FILE_ID">
		<attr key="ENTRY" value="C3_CP_EDI_EGD__20111009_V01" />
	</meta>
	<!-- !  -->
	<meta name="VERSION_NUMBER">
		<attr key="ENTRY" value="01" />
	</meta>
	<!-- !  -->
	<meta name="FILE_TIME_SPAN">
		<attr key="VALUE_TYPE" value="ISO_TIME_RANGE" type="" />
		<attr key="ENTRY" value="2011-10-09T00:00:00Z/2011-10-10T00:00:00Z" type="" />
	</meta>
	<!-- !  -->
	<meta name="FILE_TIME_SPAN">
		<attr key="VALUE_TYPE" value="ISO_TIME_RANGE" type="" />
		<attr key="ENTRY" value="2011-10-09T00:00:00Z/2011-10-10T00:00:00Z" type="" />
	</meta>
	<!-- !  -->
	<meta name="GENERATION_DATE">
		<attr key="VALUE_TYPE" value="ISO_TIME" type="" />
		<attr key="ENTRY" value="2012-04-11T15:57:15Z" type="" />
	</meta>
	<!-- !  -->
	<!-- ! include EGD (DATASET) HEADER File for Cluster-3" -->
	<!-- ! with variable definitions, metadata_type and _version" -->
	<!-- !  -->
	<attr key="include" value="C3_CH_EDI_EGD_DATASET" />
	<!-- !  -->
	<attr key="DATA_UNTIL" value="EOF" />
	<!-- !  -->
</cef>


val as = doc2 \ "attr"

println("...")

println(as)

for(a <- as) println(a)


println("......................................")

println((doc2 \ "attr").length)


for(a <- doc2 \ "attr") println(a)




println("meta \\ @name")
for(mn <- doc2 \ "meta" \\ "@name") println("\t" + mn)


println("......................................")


//for(c <- doc2 \ comment ) println(c)


println("-->");
println((doc2 \\ _).length)

