package racingcar.domain

data class TrialOrder(val value: Int) : Comparable<TrialOrder> {
    init {
        require(value > 0) {
            "The number must be positive."
        }
    }

    fun check(index: Int) {
        require(value == index + 1) {
            "The results of racing is not ordered. trialOrder='$value', givenIndex=$index"
        }
    }

    override fun compareTo(other: TrialOrder): Int {
        return this.value.compareTo(other.value)
    }
}
