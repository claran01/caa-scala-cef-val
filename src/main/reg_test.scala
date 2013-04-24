//DATA_UNTIL=EOF

//val regexPattern = "^[\\s]([0-9]+) ([a-z]+)".r

val reg1 = "^[\\s]*DATA_UNTIL(.*)$".r

val regexPattern = "^[\\s]*([\\w]+)[\\s]*=[\\s]*([.]+)[\\s]*".r


val l = "Hello = World"

// regexPattern(k, v) = l


// if(l.matches(regexPattern) == true) {
if(l.matches("^[\\s]*([\\w]+)[\\s]*=[\\s]*([.]+)[\\s]*") == true) println("OK") else println("NOT OK")

if(l.matches("^[\\s]*(\\w+)[\\s]*=[\\s]*([.]+)[\\s]*") == true) println("OK") else println("NOT OK")

if(l.matches("(\\w+) = ([.]+)") == true) println("OK") else println("NOT OK")
if(l.matches("(\\w+) = (\\w+)") == true) println("OK") else println("NOT OK")
//     // regexPattern(k, v) = l
// }
// else {
//     println("NOT OK")
// }

val regexPattern2 = "(\\w+) = ([.]+)".r



println (regexPattern2(k,v) = l)

// println(k)
// println(v)
