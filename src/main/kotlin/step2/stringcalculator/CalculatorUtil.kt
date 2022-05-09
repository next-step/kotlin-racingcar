package step2.stringcalculator

fun String.isDouble() = try {
    this.toDouble(); true
} catch (e: NumberFormatException) {
    false
}

fun String.isOperator() = this.length == 1 && "+-/*".contains(this[0])
