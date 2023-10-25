package calculator

class Number(val number: Int) {
    companion object {
        fun of(input: String): Number {
            if (!isNumber(input)) {
                throw IllegalArgumentException("숫자가 아닙니다.")
            }
            return Number(input.toInt())
        }

        private fun isNumber(value: String): Boolean {
            return value.matches(Regex("[0-9]+"))
        }
    }
}
