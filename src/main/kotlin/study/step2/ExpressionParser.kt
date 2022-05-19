package study.step2

class ExpressionParser {

    fun parse(expression: String): Expression {
        val splitted = expression.split(" ")
        val operands = splitted.filterIndexed { i, _ -> i % 2 == 0 }
            .map { it.toDouble() }
        val symbols = splitted.filterIndexed { i, _ -> i % 2 == 1 }
            .map { Symbol.of(it) }

        return Expression(operands, symbols)
    }
}
