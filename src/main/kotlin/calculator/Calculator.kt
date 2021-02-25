package calculator

import java.util.stream.Collectors.toList
import kotlin.IllegalArgumentException

const val DELIMITER = " "
const val ADD = "+"
const val SUBTRACT = "-"
const val MULTIPLY = "*"
const val DIVIDE = "/"

fun calculate(input: String): Int {
    val elements = splitInput(input)

    val left = elements[0]
    val right = elements[2]
    val operator = elements[1]

    val leftNumber = Integer.parseInt(left)
    val rightNumber = Integer.parseInt(right)

    return operate(leftNumber, rightNumber, operator)
}

private fun operate(leftNumber: Int, rightNumber: Int, operator: String): Int {
    return when (operator) {
        ADD -> leftNumber + rightNumber
        SUBTRACT -> leftNumber - rightNumber
        MULTIPLY -> leftNumber * rightNumber
        DIVIDE -> leftNumber / rightNumber
        else -> throw IllegalArgumentException()
    }
}

private fun splitInput(input: String): List<String> {
    return input.split(DELIMITER)
        .stream()
        .map { element -> element.trim() }
        .collect(toList())
}
