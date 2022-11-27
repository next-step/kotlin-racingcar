package calculator.extenstion

fun String.isInt() = toIntOrNull() != null
fun String.isNotInt() = !isInt()
