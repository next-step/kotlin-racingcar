package step2

import java.lang.IllegalArgumentException

class Calculator {

    fun calculate(expression: String) {
        validateNull(expression)
    }

    private fun validateNull(expression: String) {
        if (expression.isNullOrBlank()) throw IllegalArgumentException()
    }
}
