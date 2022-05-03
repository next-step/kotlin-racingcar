package study

data class Person(
    val name: String,
    val age: Int,
    var nickname: String? = "현구막",
)

/*
class Person {
    val name: String
    val age: Int
    var nickname: String?

    constructor(name: String, age: Int, nickname: String?) {
        this.name = name
        this.age = age
        this.nickname = nickname
    }
}
 */
