package racingcar.domain

class Car(var name: String, var position: Int = DEFAULT_POSITION) {
    init {
        require(name.length <= 5) { throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.") }
    }

    fun move(number: Int): Int {
        if (number >= 4) position++

        return position
    }

    companion object {
        const val DEFAULT_POSITION = 0
    }
}
