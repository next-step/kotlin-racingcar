package calculator

fun extractNumber(expression: String) = expression.replace(Regex("[0-9]"), "")
