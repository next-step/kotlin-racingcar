package study

data class Person(
    val name: String,
    val age: Int,
    var nickname: String? = "Guest"
) {
// 기본 값을 "Guest"로 두면서 name, age만 받는 새로운 생성자가 만들어 지는 것
//    constructor(name: String, age: Int): this(name, age, "Guest")

// data class로 만들면 아래의 보일러플레이트 코드가 사라진다
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as Person
//
//        if (name != other.name) return false
//        if (age != other.age) return false
//        return nickname == other.nickname
//    }
//
//    override fun hashCode(): Int {
//        var result = name.hashCode()
//        result = 31 * result + age
//        result = 31 * result + (nickname?.hashCode() ?: 0)
//        return result
//    }
}
