package stringcalculator

class InputConverter {
    fun extractInts(splitString: List<String>): MutableList<Int> {
        return splitString
            .filter { isNumeric(it) }
            .map { it.toInt() }
            .toMutableList()
            .asReversed()
    }

    fun convertToOperators(splitString: List<String>): List<Operator> {
        return splitString.filter { !isNumeric(it) }.map { Operator.fromOperatorString(it) }
    }

    private fun isNumeric(string: String): Boolean {
        return (string.toIntOrNull() ?: string) is Int
    }
}
