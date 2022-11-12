package calculator.domain

import java.lang.IllegalArgumentException

class ArithmeticOperator(val operators: ArrayList<String>) {

    companion object {
        const val ADDITION = "+"
        const val SUBTRACT = "-"
        const val DIVISION = "/"
        const val MULTIPLICATION = "*"
    }

    init {
        for (operator in operators) {
            checkValidOperator(operator)
        }
    }

    fun checkValidOperator(input: String) {
        if (!(input == ADDITION || input == SUBTRACT || input == DIVISION || input == MULTIPLICATION)) {
            throw IllegalArgumentException("Invalid Operation")
        }
    }
    fun getOperatorsWithIndex(): Iterable<IndexedValue<String>> {
        return operators.withIndex()
    }

    fun getOperatorsSize(): Int {
        return operators.size
    }
}
