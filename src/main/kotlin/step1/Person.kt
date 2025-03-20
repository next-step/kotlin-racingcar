package step1

data class Person(
    val name: String,
    var age: Int?,
    var nickname: String = name,
)
