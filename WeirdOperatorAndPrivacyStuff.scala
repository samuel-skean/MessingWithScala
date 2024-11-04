// All this was tested on Scastie with Scala 3.5.1
class MyNum(n: Int):
  private val num = n

  // The value `n` acts as though it was declared private in Ruby, 
  // but the value `num` acts as though declared private in Java!
  // The error messages make no distinction. What the hell?
  //private def constructorParamPrivacyTest(other: MyNum) = other.n
  private def privateValPrivacyTest(other: MyNum) = other.num
  
  // Putting infix here is entirely allowed,
  // but it's also the default:
  /* infix */ def +(other: MyNum): MyNum =
    println(f"Reciever is $this")
    MyNum(num + other.num)
  // When invoked as an operator, the receiver ends up on the right.
  def +:(other: MyNum): MyNum = this + other
  def add(other: MyNum): MyNum = this.+(other)
  // Putting infix here isn't required to use this (and other 
  // alphanumeric methods) as an infix operator, but it is
  // discouraged with a warning.
  infix def plus(other: MyNum): MyNum = this + other
  // override is required to override something, and there's no 
  // equivalent of "new" as in C# (where it's also implicit, if
  // neither override or new is specified and the method is 
  // declared in a superclass! Eek!)
  // I'm happy with that, and so would Jacob be, I think.
  override def toString = num.toString()
  
val l = List("Hello", "World").mkString("", ", ", "!")
println(l)
val x = MyNum(5)
val y = x + MyNum(6)
val z = MyNum(2) plus MyNum(7)
val a = MyNum(3).add(MyNum(9))
val b = MyNum(10) +: MyNum(20) // The receiver, here, is the right-hand-side.
val c = MyNum(40).+:(MyNum(120)) // But not here!
println(y)
