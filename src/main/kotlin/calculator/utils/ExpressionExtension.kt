package calculator.utils

fun String.splitByBlank(): List<String> = this.split("\\s".toRegex())

fun String.splitByComma(): List<String> = this.split(",".toRegex())
