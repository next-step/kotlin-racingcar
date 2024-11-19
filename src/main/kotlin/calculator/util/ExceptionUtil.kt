package calculator.util

import calculator.Operator

fun String?.getValidateInputOrThrow(): String {
    return this?.takeIf { it.isNotBlank() } ?: throw IllegalArgumentException("Input must have a value")
}

fun String.toDoubleOrThrow(): Double {
    return this.toDoubleOrNull() ?: throw NumberFormatException("Fail convert to Int. value: $this")
}

fun String.toOperatorOrThrow(): Operator = Operator.fromSymbolOrThrow(this)
