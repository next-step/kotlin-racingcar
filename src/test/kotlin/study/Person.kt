package study

data class Person(
    val name: String,
    val age: Int? = 30,
    var nickname: String? = name,
)
