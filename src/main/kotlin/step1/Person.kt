package step1

data class Person(val name: String, val age: Int?) {
    var nickname: String? = null

    constructor(name: String, age: Int? = null, nickname: String? = null) : this(name, age) {
        this.nickname = nickname
    }
}
