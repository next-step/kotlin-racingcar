package racingcar.domain

class Car(val name: String = DEFAULT_NAME, currentPosition: Int = 0) : Comparable<Car> {
    var currentPosition: Int = currentPosition
        private set

    init {
        require(name.length <= MAX_NAME_LENGTH)
        require(currentPosition >= MIN_POSITION)
    }

    override fun compareTo(other: Car): Int {
        return -1 * this.currentPosition.compareTo(other.currentPosition)
    }

    fun move(condition: Int) {
        require(condition in (MIN_BOUND..MAX_BOUND))

        if (condition >= THRESHOLD) {
            currentPosition++
        }
    }

    companion object {
        private const val DEFAULT_NAME = "-"
        private const val MAX_NAME_LENGTH = 5
        private const val MIN_POSITION = 0
        private const val THRESHOLD = 4
        const val MAX_BOUND = 9
        const val MIN_BOUND = 0
    }
}
