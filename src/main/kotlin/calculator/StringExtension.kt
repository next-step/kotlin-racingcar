package calculator

import calculator.operation.Addition
import calculator.operation.ArithmeticOperations
import calculator.operation.Division
import calculator.operation.Multiplication
import calculator.operation.Subtraction

internal fun String.calculateNumberList(): List<Int> = ArrayList<Int>().apply {
    val split = split(" ")
    split.forEachIndexed { index, str ->
        if (index % 2 == 0) {
            try {
                add(str.toInt())
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("숫자(정수)가 아님")
            }
        }
    }
}

internal fun String.calculateOperationList(): List<ArithmeticOperations> = ArrayList<ArithmeticOperations>().apply {
    val split = split(" ")
    split.forEachIndexed { index, str ->
        if (index % 2 != 0) {
            val operation = when (str) {
                "+" -> Addition()
                "-" -> Subtraction()
                "*" -> Multiplication()
                "/" -> Division()
                else -> {
                    throw IllegalArgumentException("operator not found")
                }
            }
            add(operation)
        }
    }
}
