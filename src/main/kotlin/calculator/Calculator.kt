package calculator

import java.util.stream.Collectors.toList

const val DELIMITER = " "

fun add(input: String): Int {
    val elements = input.split(DELIMITER)
        .stream()
        .map { element -> element.trim() }
        .collect(toList())

    val left = elements[0]
    val right = elements[2]

    val leftNumber = Integer.parseInt(left)
    val rightNumber = Integer.parseInt(right)

    return leftNumber + rightNumber
}
