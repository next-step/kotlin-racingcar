package calculator

object Calculator {

    fun execute(expression: List<String>): Double {
        var accumulator = expression[0].toDouble()

        for (i in 2 until expression.size step 2) {
            val operation = Operation.of(expression[i - 1]) ?: Operation.none
            accumulator = operation(accumulator, expression[i].toDouble())
        }

        return accumulator
    }
}
