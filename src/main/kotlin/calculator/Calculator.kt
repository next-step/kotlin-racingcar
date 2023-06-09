package calculator

class Calculator {
    fun calculate(expression: String): Int {
        return Expression.from(expression).getResult()
    }
}
