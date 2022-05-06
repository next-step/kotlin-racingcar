package step2

class Calculator {
    companion object {
        fun calculate(input: String): Int {
            val inputs = input.split(" ")
            var result = input.first().digitToInt()
            val inputSize = inputs.size

            for (i in 1 until inputSize step 2) {
                result = calculateOperator(result, inputs[i + 1].toInt(), inputs[i])
            }
            return result
        }

        private fun calculateOperator(result: Int, insert: Int, arithmeticSymbol: String): Int =
            when (arithmeticSymbol) {
                "+" -> result.plus(insert)
                "-" -> result.minus(insert)
                "*" -> result.times(insert)
                "/" -> result.div(insert)
                else -> throw IllegalArgumentException()
            }
    }
}