package racingcar

class Car(val position: Int) {

    constructor() : this(0)

    private companion object {
        const val MIN_POWER = 4
    }

    fun move(power: Int): Car {
        if (power >= MIN_POWER) {
            return Car(position + 1)
        }
        return this
    }
}
