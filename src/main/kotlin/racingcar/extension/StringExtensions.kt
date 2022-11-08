package racingcar.extension

fun String.isNumeric() = this.all { it.isDigit() }
