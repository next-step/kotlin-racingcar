package racingcar.model

private const val INITIAL_POSITION = 1

class Position(value: Int = INITIAL_POSITION) {
    var value = value
        private set

    init {
        require(value >= INITIAL_POSITION)
    }

    fun increase(speed: Int) {
        value += speed
    }
}
