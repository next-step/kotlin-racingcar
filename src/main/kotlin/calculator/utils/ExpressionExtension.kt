package calculator.utils

fun String.rawExpressionSplit(): List<String> = this.split("\\s".toRegex())
