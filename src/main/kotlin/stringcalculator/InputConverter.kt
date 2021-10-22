package stringcalculator

import stringcalculator.operations.Add
import stringcalculator.operations.Divide
import stringcalculator.operations.Multiply
import stringcalculator.operations.Operation
import stringcalculator.operations.Subtract

enum class Operator(val operatorString: String, val operation: Operation) {
    ADD("+", Add()),
    SUBTRACT("-", Subtract()),
    MULTIPLY("*", Multiply()),
    DIVIDE("/", Divide());

    companion object {
        fun fromOperatorString(operatorString: String): Operator {
            return values().first { it.operatorString == operatorString }
        }
    }
}

class InputConverter {
    fun extractInts(splitString: List<String>): ArrayDeque<Int> {
        return ArrayDeque(splitString.filter { isNumeric(it) }.map { it.toInt() })
    }

    fun convertToOperations(splitString: List<String>): List<Operation> {
        return splitString.filter { !isNumeric(it) }.map { Operator.fromOperatorString(it).operation }
    }

    private fun isNumeric(string: String): Boolean {
        return (string.toIntOrNull() ?: string) is Int
    }
}
