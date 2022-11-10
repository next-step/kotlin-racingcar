package racingcar.model

private const val INITIAL_POSITION = 1

class Position(var value: Int = INITIAL_POSITION) {

    init {
        require(value >= INITIAL_POSITION)
    }

    fun increase() = value++
}
