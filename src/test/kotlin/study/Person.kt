package study

data class Person(
    val name: String,
    val age: Int,
    val nickname: String? = name
)
//) {
////    constructor(name: String, age: Int) : this(name, age, null) 부생성자
//}