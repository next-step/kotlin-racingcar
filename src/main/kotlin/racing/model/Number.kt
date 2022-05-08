package racing.model

class Number(
    private val number: Int
) {

    companion object {
        const val MIN_NUMBER = 0
        const val MAX_NUMBER = 9
    }

    init {
        validateNumberRange(number)
    }

    private fun validateNumberRange(number: Int) {
        require(number in MIN_NUMBER..MAX_NUMBER) {
            "숫자는 $MIN_NUMBER 이상 $MAX_NUMBER 이하이어야 합니다. (number: $number)"
        }
    }

    fun isGreaterThanOrEqualTo(number: Int): Boolean {
        return this.number >= number
    }
}
