//DATA_UNTIL=EOF

//val regexPattern = "^[\\s]([0-9]+) ([a-z]+)".r

import java.util.regex.Pattern

val reg1 = "^[\\s]*DATA_UNTIL(.*)$".r


val p = Pattern.compile("^[\\s]*([\\w]*)[\\s]*=[\\s]*(.*)[\\s]*$")

val RegX = "^[\\s]*([\\w]*)[\\s]*=[\\s]*(.*)[\\s]*$".r


//val regexPattern = "^[\\s]*([\\w]+)[\\s]*=[\\s]*([.]+)[\\s]*".r


val l = "Hello = \"World\""


println("------------------")
val RegX(a,b) = l
println("------------------")


// regexPattern(k, v) = l

val test = Array("key_123=value",
    			 "key=\"value stings\"",
    			 " key = value",
    			 " key = \"value stings\"")
 


test.map(println)



var m1 = p.matcher(test(0))

if(m1.matches == true && m1.groupCount == 2) println("OK!!!!!!!!!!!!!") else println("xxxxxxxxxxx")

// if(l.matches(regexPattern) == true) {
if(l.matches("^[\\s]*([\\w]*)[\\s]*=[\\s]*(.*)[\\s]*$") == true) println("OK") else println("NOT OK")
if(l.matches("^[\\s]*([\\w]*)[\\s]*=[\\s]*(.*)[\\s]*$") == true) println("OK") else println("NOT OK")

if(l.matches("(\\w+) = ([.]+)") == true) println("OK") else println("NOT OK")
if(l.matches("(\\w+) = (\\w+)") == true) println("OK") else println("NOT OK")
//     // regexPattern(k, v) = l
// }
// else {
//     println("NOT OK")
// }

val regexPattern2 = "^[\\s]*([\\w]*)[\\s]*=[\\s]*(.*)[\\s]*$".r


//var k, v
regexPattern2(k,v) = l

// println(k)
// println(v)
