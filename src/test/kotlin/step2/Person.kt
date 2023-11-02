package study

data class Person(
    val name: String,
    val age: Int,
    var nickname: String? = name
) {
    constructor(name: String, age: Int) : this(name, age, name)
}
