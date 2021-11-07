package step3.racingcar.domain

class CurrentTurn(var _currentTurn: Int = 0) {
    val value: Int
        get() = _currentTurn

    init {
        require(
            START_TURN <= _currentTurn
        )
    }

    fun increaseTurn() {
        _currentTurn++
    }

    companion object {
        private const val START_TURN = 0
    }
}
