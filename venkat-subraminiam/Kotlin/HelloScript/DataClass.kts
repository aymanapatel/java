 data class Person(val name:String, val age: Int, val email: String)
    
val person = Person("ayman", 12 , "aym@man.com")
val (name, _, email) = person // No error. Fetch what you need
println(" $name $email")
