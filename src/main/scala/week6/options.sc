case class User(
                 id: Int,
                 firstName: String,
                 lastName: String,
                 age: Int,
                 gender: Option[String])

object UserRepository {
  private val users = Map(1 -> User(1, "John", "Doe", 32, Some("male")),
    2 -> User(2, "Johanna", "Doe", 30, None))
  def findById(id: Int): Option[User] = users.get(id)
  def findAll = users.values
}

//Access strategies
UserRepository.findById(10).getOrElse("no user")
UserRepository.findById(1).getOrElse("no user")

UserRepository.findById(1) match{
  case Some(x) => x
  case None => "no user"
}

//Option ACT like a collection so you can
//invoke the same useful function on it
//None is considered an empty list
val opt = UserRepository.findById(1)
val optNo = UserRepository.findById(10)

opt.foreach( u => println("My user "+u))
optNo.foreach( u => println(u)) //it works!

//A map on Option[A] can return an Option[B]
opt.map( u => u.age)
optNo.map( u => u.age)

//Filter also works well with Option
opt.filter(_.age > 20)
opt.filter(_.age > 60)
optNo.filter(_.age > 10)

//Flat map is another good way to deal with Options
//A list of options can be view like a list of lists
UserRepository.findAll.map(_.gender)
UserRepository.findAll.flatMap(_.gender)
for {
  user <- UserRepository.findAll
  gender <- user.gender
} yield gender

//Options concatenation
optNo orElse opt
opt orElse optNo
optNo orElse opt.get.gender