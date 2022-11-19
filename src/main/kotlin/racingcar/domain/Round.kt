package racingcar.domain

data class Round(private val round: Int) {
    init {
        if (round < MIN_THRESHOLD) throw IllegalArgumentException("The minimum value for round should be greater than $MIN_THRESHOLD ")
    }

    fun next(): Round {
        return if (hasNext()) {
            Round(round - 1)
        } else {
            throw IllegalStateException("There is no left round")
        }
    }

    fun hasNext() = round > MIN_THRESHOLD

    companion object {
        private const val MIN_THRESHOLD = 0
    }
}
