package calculator

class Calculator {
    companion object {
        fun calculate(formula: String?): Int {
            if (formula.isNullOrBlank()) {
                throw IllegalArgumentException("null 또는 공백을 입력할 수 없습니다.")
            }
            val split = formula.split(" ")
            var result = split[0].toInt()
            for (i: Int in 1 until split.size step (2)) {
                val operator = split[i]
                val target = split[i + 1].toInt()
                result = calculate(result, target, operator)
            }
            return result
        }

        private fun calculate(first: Int, second: Int, operator: String): Int {
            return when (operator) {
                "+" -> first + second
                "-" -> first - second
                "*" -> first * second
                "/" -> first / second
                else -> throw IllegalArgumentException("잘못된 사칙연산입니다.")
            }
        }
    }
}
