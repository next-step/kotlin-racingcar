package racingcar

class Car(val position: Int) {
    constructor() : this(INITIAL_POSITION)

    fun move(power: Int): Car {
        validatePower(power)
        if (power >= MINIMUM_AMOUNT_TO_MOVE) {
            return Car(position + 1)
        }
        return this
    }

    private fun validatePower(power: Int) {
        require(power in MINIMUM_MOVE_POWER..MAXIMUM_MOVE_POWER) {
            "자동차의 움직임은 0 이상 9 이하의 값만 가능합니다."
        }
    }

    private companion object {
        const val INITIAL_POSITION = 0
        const val MINIMUM_AMOUNT_TO_MOVE = 4
        const val MAXIMUM_MOVE_POWER = 9
        const val MINIMUM_MOVE_POWER = 0
    }
}
