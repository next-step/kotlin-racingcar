package study

data class Person(
    val name: String,
    val age: Long,
    val nickname: String? = name,
)
