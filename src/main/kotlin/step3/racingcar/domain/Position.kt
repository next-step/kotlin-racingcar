package step3.racingcar.domain

data class Position(val value: Int) {
    init {
        require(START_POSITION <= value)
    }

    companion object {
        private const val START_POSITION = 0
    }
}
