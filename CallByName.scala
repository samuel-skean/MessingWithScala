// All this was tested on Scastie with Scala 3.5.1

// This is a profoundly weird feature to me, but at least there was no surprise
// here: The ability to use braces without parentheses to pass the last argument
// is just syntax sugar, and works the same as if you write those parentheses.

def `callByValueDoesn'tUse`(x: String): Unit =
  println("Hello world")

def callByValueUsesMultipleTimes(x: String): Unit =
  println(f"Hello $x $x $x")

def `callByNameDoesn'tUse`(x: => String): Unit =
  println("Hello world")

def callByNameUsesMultipleTimes(x: => String): Unit =
  println(f"Hello $x $x $x")

println("LOG: Testing `callByValueDoesn'tUse`")
`callByValueDoesn'tUse`("An unused string")

`callByValueDoesn'tUse` {
  "An unused string"
}

`callByValueDoesn'tUse` {
  println("A string that gets printed, once.")
  "An unused string"
}

`callByValueDoesn'tUse`({
  println("A string that gets printed, once.")
  "An unused string"
})


println("LOG: Testing `callByValueUsesMultipleTimes`")
callByValueUsesMultipleTimes("A string used multiple times")

callByValueUsesMultipleTimes {
  "Another string used multiple times"
}

callByValueUsesMultipleTimes {
  println("A string that gets printed, once.")
  "A string used multiple times"
}

callByValueUsesMultipleTimes({
  println("Another string that gets printed, once.")
  "Another string used multiple times"
})

println("LOG: Testing `callByNameDoesn'tUse`")
`callByNameDoesn'tUse`("An unused string")

`callByNameDoesn'tUse` {
  "An unused string"
}

`callByNameDoesn'tUse` {
  println("A string that never gets printed")
  "An unused string"
}

`callByNameDoesn'tUse`({
  println("Another string that never gets printed")
  "An unused string"
})

println("LOG: Testing `callByNameUsesMultipleTimes`")
callByNameUsesMultipleTimes("A string used multiple times")

callByNameUsesMultipleTimes {
  "Another string used multiple times"
}

callByNameUsesMultipleTimes {
  println("A string that gets printed multiple times")
  "A*nother* nother string used multiple times"
}

callByNameUsesMultipleTimes({
  println("Another string that gets printed multiple times")
  "*Yet* another string used multiple times"
})