package step3.domain

class Car(val name: String, var position: Int = 0) {
    init {
        require(name.length <= NAME_MAXIMUM_LIMIT) { "Car.name 은 ${NAME_MAXIMUM_LIMIT}자를 초과할 수 없습니다!" }
    }

    fun move() {
        position++
    }

    companion object {
        const val NAME_MAXIMUM_LIMIT = 5
    }
}
