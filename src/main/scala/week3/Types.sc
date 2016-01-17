object Types{

  /**
    * Any, AnyRef and AnyVal are the supertypes of scala
    * Any is the GOD type. it can handle everything
    * AnyRef is the GOD type among the references. It is
    * like an alias for java.lang.Object, every reference
    * can be handled by AnyRef
    * AnyVal is the GOD type among the primitive types.
    * The primitive types follow the java conversion conventions
    * Byte to Short to Int to Long to Float to Double
    * and Char to Int
    */
  def helloSuperTypes(a:Any, b:AnyRef, c:AnyVal):String = {
      "Hello "+a+" "+b+" "+c+""
  }

}

Types.helloSuperTypes("types", "ref", 1)
Types.helloSuperTypes(1, "ref", 1)
//Error
//Types.helloTypes("types", 1, "ref")

//Null type is the subtype of all the reference types
//The Null type can admit only one value: null
//any reference can handle this value of the Null Type.
val a = null
Types.helloSuperTypes(null, null, 0)

//The Nothing type is the subtype of ALL the types.
//This type doesn't have a value so you cannot assign it
//but it is used only to signal abnormal termination or
//initialize empty collection
def error() = throw new Error
val aSet:Set[Nothing]
