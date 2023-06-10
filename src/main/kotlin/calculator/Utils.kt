package calculator

fun String.toOperation(): Operation = when (this) {
    "+" -> Operation.ADD
    "-" -> Operation.SUBTRACT
    "*" -> Operation.MULTIPLY
    "/" -> Operation.DIVIDE
    else -> throw IllegalArgumentException("$this cannot convert to Operation")
}
