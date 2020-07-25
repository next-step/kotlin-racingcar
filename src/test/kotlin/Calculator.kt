class Calculator {
    private val add = "+"
    private val minus = "-"
    private val times = "*"
    private val divide = "/"

    fun calculate(formula: String): Double {
        if (formula.isBlank()) {
            throw IllegalArgumentException("값을 입력해 주세요")
        }

        val values = formula.split(" ")
        var outcome = values[0].toDouble()
        var operator = ""

        for (str in 1 until values.size) {
            val tmp = values[str]

            if (!isOperator(tmp)) {
                outcome = calculate(outcome, tmp.toDouble(), operator)
            } else {
                operator = tmp
            }
        }
        return outcome
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
