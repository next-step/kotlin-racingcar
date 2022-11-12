package racingcar.extension

private val DELIMITER_REPLACE_REGEX = "\\s+".toRegex()

fun String.isNumeric() = this.all { it.isDigit() }
fun String.removeWhitespaces() = this.replace(DELIMITER_REPLACE_REGEX, "")
