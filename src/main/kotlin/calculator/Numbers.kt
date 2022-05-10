package calculator

fun isNumeric(numericString: String): Boolean {
    return numericString.toDoubleOrNull() != null
}
