package step3.racingcar.expansion

fun String.isDigit(): Boolean = this.toIntOrNull() != null
fun String.isNotDigit(): Boolean = !this.isDigit()
