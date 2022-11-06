package calculator.utils

fun String.splitByBlank(): List<String> = this.split("\\s".toRegex())
