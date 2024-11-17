package step2.util

import step2.OperatorType

fun String?.getValidateInputOrThrow(): String {
    return this?.takeIf { it.isNotBlank() } ?: throw IllegalArgumentException("Input must have a value")
}

fun String.toDoubleOrThrow(): Double {
    return this.toDoubleOrNull() ?: throw NumberFormatException("Fail convert to Int. value: $this")
}

fun String.toOperatorOrThrow(): OperatorType =
    when (this) {
        "+" -> OperatorType.ADD
        "-" -> OperatorType.SUBTRACT
        "*" -> OperatorType.MULTIPLY
        "/" -> OperatorType.DIVIDE
        else -> throw IllegalArgumentException("invalid operator: $this")
    }
