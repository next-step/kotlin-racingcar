package racing.domain

class Car(val name: String, position: Int = 0) {

    var position = position
        private set

    init {
        require(name.length <= CAR_NAME_LIMIT) {
            "자동차의 이름은 ${CAR_NAME_LIMIT}글자를 초과할 수 없습니다."
        }
    }

    fun move(num: Int) {
        if (num >= FORWARD_MOVE) {
            position++
        }
    }

    companion object {
        const val FORWARD_MOVE: Int = 4
        const val CAR_NAME_LIMIT: Int = 5
        fun produce(name: String, position: Int = 0) = Car(name, position)
    }
}
