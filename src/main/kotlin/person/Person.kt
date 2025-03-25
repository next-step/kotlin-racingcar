package person

data class Person(
    val name: String,
    var age: Int?,
    var nickname: String = name,
)
