package calculator

object Calculator {
    fun calculate(expression: Expression): Int {
        return expression.numbers
            .reduceIndexed { index, first, second ->
                expression.operators[index - 1].calculate(first, second)
            }
    }
}
