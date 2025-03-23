package racingcar

class Round(
    private var value: Int,
) {
    init {
        require(value in MINIMUM_ROUND..MAXIMUM_ROUND) {
            "Racing game rounds must be between 1 and 10."
        }
    }

    val canContinue: Boolean
        get() = value > 0

    fun proceed() {
        check(value > 0) {
            "There is no round to proceed."
        }
        value--
    }

    companion object {
        private const val MINIMUM_ROUND = 1
        private const val MAXIMUM_ROUND = 10
    }
}
