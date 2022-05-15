package study.step2

class ExpressionParser {

    fun parse(expression: String): Pair<List<Double>, List<Operator>> {
        val splitted = expression.split(" ")
        val operands = splitted.filterIndexed { i, _ -> i % 2 == 0 }
            .map { it.toDouble() }
        val operators = splitted.filterIndexed { i, _ -> i % 2 == 1 }
            .map { Operator.of(it) }

        return operands to operators
    }
}
