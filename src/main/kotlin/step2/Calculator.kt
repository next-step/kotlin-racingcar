package step2

class Calculator {

    private val parser = InputParser()

    fun calculate(input: String?): Double {
        val inputs = parser.parse(input)
        var result = inputs[0].toDouble()

        for (i in 2 until inputs.size step (2)) {
            val arithmeticSymbol = inputs[i - 1]
            val value = inputs[i].toDouble()

            result = Operator.findBy(arithmeticSymbol).operation(result, value)
        }

        return result
    }
}
