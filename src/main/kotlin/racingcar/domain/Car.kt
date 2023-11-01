package racingcar.domain

class Car(
    carName: String,
    val position: Int = DEFAULT_POSITION
) {

    init {
        require(carName.carNameCheck()) { "자동차 이름은 ${CAR_NAME_MAX_LENGTH}자 이하만 가능합니다." }
    }

    val name: String = carName

    fun move(value: Int): Car {
        if (isMove(value)) return Car(name, position + 1)
        return this
    }

    private fun isMove(value: Int): Boolean {
        return value >= MOVE_CONDITION
    }

    private fun String.carNameCheck(): Boolean {
        return this.length <= CAR_NAME_MAX_LENGTH
    }

    companion object {
        private const val CAR_NAME_MAX_LENGTH = 5
        private const val MOVE_CONDITION = 4
        private const val DEFAULT_POSITION = 0
    }
}
