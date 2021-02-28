package calculator

class StringCalculator {
    fun calculate(expression: String?): Int {
        if (expression == null || expression.isBlank()) {
            throw IllegalArgumentException("The expression is null or blank. expression='$expression'")
        }

        return expression.toInt()
    }
}
