package racingcar.domain.racing

data class TrialOrder(val value: Int) : Comparable<TrialOrder> {
    init {
        require(value > 0) {
            "The number must be positive."
        }
    }

    fun checkOrder(index: Int) {
        require(value == index + 1) {
            "The results of racing is not ordered. trialOrder='$value', givenIndex=$index"
        }
    }

    override fun compareTo(other: TrialOrder): Int {
        return this.value.compareTo(other.value)
    }
}
