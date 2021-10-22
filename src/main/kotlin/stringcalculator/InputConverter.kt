package stringcalculator

class InputConverter {
    fun extractInts(splitString: List<String>): ArrayDeque<Int> {
        return ArrayDeque(splitString.filter { isNumeric(it) }.map { it.toInt() })
    }

    fun convertToOperators(splitString: List<String>): List<Operator> {
        return splitString.filter { !isNumeric(it) }.map { Operator.fromOperatorString(it) }
    }

    private fun isNumeric(string: String): Boolean {
        return (string.toIntOrNull() ?: string) is Int
    }
}
