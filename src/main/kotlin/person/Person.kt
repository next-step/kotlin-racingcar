package person

//Person.java를 코틀린으로 변환
data class Person (
    val name: String,
    val age: Int,
    var nickname: String? = "Guest"
 )