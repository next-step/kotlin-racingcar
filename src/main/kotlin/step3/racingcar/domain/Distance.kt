package step3.racingcar.domain

data class Distance(val value: Int) {
    init {
        require(STOP <= value)
    }

    companion object {
        private const val STOP = 0
    }
}
