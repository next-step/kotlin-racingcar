package stringcalculator

import util.KnownException

class StringCalculator {
    fun execute(input: String): Int {
        if (input.isBlank()) {
            throw IllegalArgumentException(KnownException.INVALID_INPUT.message)
        }
        inputCalculator(input).let { value ->
            return value.result
        }
    }

    private fun inputCalculator(input: String): Calculator {
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
