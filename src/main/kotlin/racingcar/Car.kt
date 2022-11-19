package racingcar

class Car {
    private var distance: Int = 0

    fun move(): Int {
        val number = numberRange.random()
        if (number >= 4) {
            distance += 1
        }
        return distance
    }

    companion object {
        private val numberRange = (0..9)
    }
}
