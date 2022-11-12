package racingcar.utils

fun String.splitByComma(): List<String> = this.split(",".toRegex())

fun List<String>.joinToStringByComma(): String = this.joinToString(",") { it }
