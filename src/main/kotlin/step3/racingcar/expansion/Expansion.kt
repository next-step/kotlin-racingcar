package step3.racingcar.expansion

fun Int.greaterOrEqual(target: Int): Boolean = this >= target

fun String.isDigit(): Boolean = this.toIntOrNull() != null
fun String.isNotDigit(): Boolean = !this.isDigit()
