package step2.calculator

class NumberPair private constructor(
    val first: Double,
    val second: Double
) {

    companion object {
        fun of(first: String, second: String): NumberPair {
            return NumberPair(
                first = toDouble(first),
                second = toDouble(second)
            )
        }

        private fun toDouble(value: String): Double {
            return try {
                value.toDouble()
            } catch (cause: NumberFormatException) {
                throw IllegalArgumentException("숫자가 아닙니다. cause = `$value`")
            }
        }
    }
}
