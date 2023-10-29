package racingcar

class Car(val position: Int) {


    constructor() : this(INITIAL_POSITION)

    private companion object {
        const val INITIAL_POSITION = 0
        const val MINIMUM_MOVE_POWER = 4
    }

    fun move(power: Int): Car {
        if (power >= MINIMUM_MOVE_POWER) {
            return Car(position + 1)
        }
        return this
    }
}
