package stringcalculator

import stringcalculator.operations.Add
import stringcalculator.operations.Divide
import stringcalculator.operations.Multiply
import stringcalculator.operations.Operation
import stringcalculator.operations.Subtract

class InputConverter {
    fun extractInts(splitString: List<String>): ArrayDeque<Int> {
        return ArrayDeque(splitString.filter { isNumeric(it) }.map { it.toInt() })
    }

    fun convertToOperations(splitString: List<String>): List<Operation> {
        return splitString.filter { !isNumeric(it) }.map { convertToOperation(it) }
    }

    private fun isNumeric(string: String): Boolean {
        return (string.toIntOrNull() ?: string) is Int
    }

    @Throws(IllegalArgumentException::class)
    private fun convertToOperation(string: String): Operation {
        return when (string) {
            "+" -> Add()
            "-" -> Subtract()
            "*" -> Multiply()
            "/" -> Divide()
            else -> throw IllegalArgumentException("올바른 연산자가 아닙니다: '$string'")
        }
    }
}
