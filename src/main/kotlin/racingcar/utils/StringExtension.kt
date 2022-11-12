package racingcar.utils

fun String.splitByComma(): List<String> = this.split(",".toRegex())
