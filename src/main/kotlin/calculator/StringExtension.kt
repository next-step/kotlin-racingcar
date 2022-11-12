package calculator

import calculator.operation.Addition
import calculator.operation.ArithmeticOperations
import calculator.operation.Division
import calculator.operation.Multiplication
import calculator.operation.Subtraction

fun String.calculateNumberList(): List<Int> = ArrayList<Int>().apply {
    val split = split(" ")
    split.forEachIndexed { index, str ->
        if (index % 2 == 0) {
            try {
                add(str.toInt())
            } catch (e: NumberFormatException) {
                throw e
            }
        }
    }
}

fun String.calculateOperationList(): List<ArithmeticOperations> = ArrayList<ArithmeticOperations>().apply {
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
