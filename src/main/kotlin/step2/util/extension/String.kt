package step2.util.extension

fun String.splitBy(delimiter: String): List<String> {
    return split(delimiter)
}

fun String?.splitBy(delimiter: String, message: String): List<String> {
    return requireNotNull(this?.splitBy(delimiter), { message })
}

fun String.toDouble(message: String): Double {
    return requireNotNull(toDoubleOrNull(), { plus(message) })
}
