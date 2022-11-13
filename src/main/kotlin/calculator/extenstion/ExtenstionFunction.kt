package calculator.extenstion

fun String.isInt() = toIntOrNull()?.let { true } ?: false
fun String.isNotInt() = !isInt()
