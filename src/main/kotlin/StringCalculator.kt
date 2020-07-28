class StringCalculator {
    companion object {
        private val INVALID_PATTERN = Regex("^d+((\\s)[\\+\\-\\*\\/](\\s)d+)+?")

        fun calculate(numericalString: String?): Int {

            if (numericalString.isNullOrBlank()) {
                throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자일 경우")
            }

            if (INVALID_PATTERN.matches(numericalString)) {
                throw IllegalArgumentException("잘못된 못한 수식")
            }

            val splitString = numericalString.split(" ")

            var result: Int = splitString[0].toInt()

            for (i in 1 until splitString.size step 2) {
                val first = result
                val sign = splitString[i]
                val second = splitString[i + 1].toInt()

                result = Operate.signCheck(sign).operator(first, second)
            }

            return result
        }
    }
}

enum class Operate(val sign: String, val operator: (Int, Int) -> Int) {
    ADD("+", { x, y -> x + y }),
    SUB("-", { x, y -> x - y }),
    MUL("*", { x, y -> x * y }),
    DIV("/", { x, y -> x / y });

    companion object {
        fun signCheck(sign: String): Operate {
            return values().firstOrNull { it.sign == sign } ?: throw IllegalArgumentException("사칙연산이 아닙니다.")
        }
    }
}
