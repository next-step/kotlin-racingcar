package calculator.util

fun String.isNumeric() = this.all { it.isDigit() }
