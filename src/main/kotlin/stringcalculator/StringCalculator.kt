package stringcalculator

import util.CalculatorException

class StringCalculator {
    fun execute(input: String?): Int {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException(CalculatorException.INVALID_INPUT.message)
        }
        calculate(input).let { value ->
            return value.result
        }
    }

    private fun calculate(input: String): Calculator {
        val value = Calculator()
        input.split(BLANK).forEach {
            when (it.toIntOrNull()) {
                null -> value.operator = Operator.of(it)
                else -> {
                    value.calculate()
                    value.operator = Operator.of(it)
                }
            }
        }
        return value
    }

    companion object {
        private const val BLANK = " "
    }
}
