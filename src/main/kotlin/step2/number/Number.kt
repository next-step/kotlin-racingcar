package step2.number

class Number(
    val value: Int
) {
    companion object {
        fun of(value: String): Number {
            return Number(parse(value))
        }

        private fun parse(value: String): Int {
            try {
                return value.toInt()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("$value : 숫자가 아닙니다.")
            }
        }
    }
}
