package study

class Person(
    val name: String,
    val age: Int,
    var nickname: String?,
) {
    constructor(name: String, age: Int) : this(name, age, "Guest")
}
