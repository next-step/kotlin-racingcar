package step3.racingcar.extension

fun String.isDigit(): Boolean = this.toIntOrNull() != null
fun String.isNotDigit(): Boolean = !this.isDigit()
