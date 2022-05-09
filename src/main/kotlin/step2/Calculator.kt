package step2

class Calculator {

    fun calculate(input: String): Double {
        val inputs = input.split(DELIMITER)
        var result = inputs[0].toDouble()
        for (i in 1 until inputs.size step 2) {
            val operator = Operator.of(inputs[i].first())
            result = operator.operate(result, inputs[i + 1].toDouble())
        }

        return result
    }

    companion object {
        const val DELIMITER = " "
    }
}
