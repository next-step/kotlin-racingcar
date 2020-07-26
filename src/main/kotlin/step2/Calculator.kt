package step2

class Calculator {
    private val add = "+"
    private val minus = "-"
    private val times = "*"
    private val divide = "/"

    fun calculate(formula: String): Double {
        require(formula.isNotBlank()) { "값을 입력해 주세요" }

        val values = formula.split(" ")
        var outcome = values[0].toDouble()
        var operator = ""

        for (str in 1 until values.size) {
            val value = values[str]

            if (isNumber(value)) outcome = calculate(outcome, value.toDouble(), operator)
            if (isOperator(value)) operator = value
            if (!isNumber(value) && !isOperator(value)) throw IllegalArgumentException("올바른 값이 아닙니다.")
        }
        return outcome
    }

    private fun isNumber(str: String): Boolean {
        return try {
            str.toDouble()
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    private fun isOperator(str: String): Boolean {
        return str == add || str == minus || str == times || str == divide
    }

    private fun calculate(current: Double, change: Double, operator: String): Double {
        if (operator == add) return current + change
        if (operator == minus) return current - change
        if (operator == times) return current * change
        if (operator == divide) return current / change
        return current / change
    }
}
