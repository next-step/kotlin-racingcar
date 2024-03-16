package study

data class Person(
    val name: String,
    val age: Int,
    val nickname: String? = name
)

//class Person {
//    val name: String
//    val age: Int
//    val nickname: String?
//
//    constructor(name: String, age: Int, nickname: String?) {
//        this.name = name
//        this.age = age
//        this.nickname = nickname
//    }
//}

//class Person(
//    val name: String,
//    val age: Int,
//    val nickname: String?
//)
