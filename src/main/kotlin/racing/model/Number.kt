package racing.model

@JvmInline
value class Number(
    private val number: Int
) {

    init {
        validateNumberRange(number)
    }

    operator fun compareTo(number: Int): Int = this.number.compareTo(number)

    private fun validateNumberRange(number: Int) {
        require(number in MIN_NUMBER..MAX_NUMBER) {
            "숫자는 $MIN_NUMBER 이상 $MAX_NUMBER 이하이어야 합니다. (number: $number)"
        }
    }

    companion object {
        private const val MIN_NUMBER = 0
        private const val MAX_NUMBER = 9

        fun random(): Number {
            val randomNumber = (MIN_NUMBER..MAX_NUMBER).random()
            return Number(randomNumber)
        }
    }
}
