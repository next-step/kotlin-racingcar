package calculator

fun isNumeric(toCheck: String): Boolean {
    return toCheck.toDoubleOrNull() != null
}
