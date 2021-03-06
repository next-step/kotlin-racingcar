package racingcar.racing

data class TrialOrder(val value: Int) : Comparable<TrialOrder> {
    init {
        require(value > 0) {
            "The number must be positive."
        }
    }

    override fun compareTo(other: TrialOrder): Int {
        return this.value.compareTo(other.value)
    }
}
