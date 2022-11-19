package racing.domain

class Car(name: String, position: Int = 0) {

    var name = name
        private set
    var position = position
        private set

    init {
        if (name.length > CAR_NAME_LIMIT)
            throw IllegalArgumentException("자동차의 이름은 ${CAR_NAME_LIMIT}글자를 초과할 수 없습니다.")
    }

    fun move(num: Int) {
        if (num >= FORWARD_MOVE) {
            position++
        }
    }

    companion object {
        const val FORWARD_MOVE: Int = 4
        const val CAR_NAME_LIMIT: Int = 5
    }
}
