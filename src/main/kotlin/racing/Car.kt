package racing

class Car(val name: String, var position: Int) {

    constructor(name: String) : this(name, 0)

    init {
        require(name.length <= MAXIMUM_NAME_LENGTH) { "자동차의 이름은 5자를 초과할 수 없습니다." }
    }

    fun move() {
        this.position += 1
    }

    companion object {
        private const val MAXIMUM_NAME_LENGTH: Int = 5
    }
}
