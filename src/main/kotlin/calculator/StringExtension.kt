package calculator

import calculator.operation.ArithmeticOperations

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
            try {
                val operatorType = OperatorType.commandOfType(str)
                add(operatorType.operator)
            } catch (e: NoSuchElementException) {
                throw IllegalArgumentException("operator not found")
            }
        }
    }
}
