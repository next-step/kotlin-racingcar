package racingcar

class Car(var position: Int) {
    companion object {
        private const val START_POSITION = 0
    }

    constructor() : this(START_POSITION)

    fun forward() {
        position++
    }

    fun retrievePosition(): Int {
        return position
    }
}
