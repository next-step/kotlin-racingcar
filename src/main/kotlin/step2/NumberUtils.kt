package step2

fun isNumeric(toCheck: String): Boolean {
    return toCheck.toDoubleOrNull() != null
}
