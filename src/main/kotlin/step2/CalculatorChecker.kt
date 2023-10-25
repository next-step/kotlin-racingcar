package step2

class CalculatorChecker {
    fun isNumber(str: String): Boolean {
        return str.toIntOrNull() != null
    }

    fun isExpression(str: String): Boolean {
        return str == "+" || str == "-" || str == "*" || str == "/"
    }

    fun isEven(idx: Int) = idx % 2 == 0

    fun isInputValid(input: String?): Boolean {
        if (input == null) return false
        if (input.isBlank()) return false

        return true
    }
}
