class StringCalculator {
    companion object {
        const val add = "+"
        const val subtraction = "-"
        const val multiply = "*"
        const val divide = "/"

        fun calculate(numericalString: String?): Int {

            if (numericalString.isNullOrBlank()) {
                throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자일 경우")
            }

            val splitNumericalString = numericalString.split(" ")

            var result: Int = splitNumericalString[0].toInt()

            for (i in 1 until splitNumericalString.size step 2) {
                result = operation(
                    first = result,
                    operator = splitNumericalString[i],
                    second = splitNumericalString[i + 1].toInt()
                )
            }

            return result
        }

        fun operation(operator: String, first: Int, second: Int): Int {
            return when (operator) {
                add -> first + second
                subtraction -> first - second
                multiply -> first * second
                divide -> first / second
                else -> throw throw IllegalArgumentException("사칙연산 기호가 아닌 경우")
            }
        }
    }
}


