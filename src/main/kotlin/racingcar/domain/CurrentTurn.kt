package racingcar.domain

class CurrentTurn(currentTurn: Int = START_TURN) {
    var value: Int = currentTurn
        private set

    init {
        require(START_TURN <= value)
    }

    fun increaseTurn() {
        value++
    }

    companion object {
        private const val START_TURN = 0
    }
}
