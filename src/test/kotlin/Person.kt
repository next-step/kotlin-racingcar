package study

data class Person(
    val name: String,
    val age: Int,
    var nickname: String? = "Guest"
) {
//    constructor(name: String, age: Int): this(name, age, "guest")

//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as Person
//
//        if (name != other.name) return false
//        if (age != other.age) return false
//        if (nickname != other.nickname) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = name.hashCode()
//        result = 31 * result + age
//        result = 31 * result + (nickname?.hashCode() ?: 0)
//        return result
//    }
}
