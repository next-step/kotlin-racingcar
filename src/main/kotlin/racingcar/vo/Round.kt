package racingcar.vo

data class Round(private val round: Int) {
    init {
        require(round >= MIN_THRESHOLD) { "The minimum value for round should be greater than $MIN_THRESHOLD" }
    }

    fun next(): Round {
        check(hasNext()) { "There is no left round" }
        return Round(round - 1)
    }

    fun hasNext() = round > MIN_THRESHOLD

    companion object {
        private const val MIN_THRESHOLD = 0
    }
}
