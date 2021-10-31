package step3.racingcar.domain

data class Position(val value: Int) {
    init {
        require(STOP <= value)
    }

    companion object {
        private const val STOP = 0
    }
}
