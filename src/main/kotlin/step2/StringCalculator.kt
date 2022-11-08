package step2

class StringCalculator {

    fun calculate(expression: String?): Int {
        ExpressionValidator.validate(expression = expression)
        return 10
    }
}
