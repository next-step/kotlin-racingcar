package racingCar

class Car {
    var distance = DEFAULT_DISTANCE
        private set

    fun move(number: Int) {
        if (number >= FORWARD_NUMBER) {
            distance++
        }
    }

    companion object {
        const val FORWARD_NUMBER = 4
        const val DEFAULT_DISTANCE = 0
    }
}
