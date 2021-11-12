package racingcar.domain.racing

data class FinalLab(val value: Int) {
    init {
        require(MINIMUM_FINAL_LAB < value)
    }

    companion object {
        private const val MINIMUM_FINAL_LAB = 0
    }
}
