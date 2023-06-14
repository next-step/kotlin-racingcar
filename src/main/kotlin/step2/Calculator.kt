package step2

import step2.Operator.Companion.getBySymbol

const val INPUTS_FIRST_VALUE = 1
const val ARRAY_SIZE = 2
const val INTERVAL_SIZE = 2

class Calculator {

    fun calculate(first: Int, symbol: String, second: Int): Int = when (getBySymbol(symbol)) {
        Operator.PLUS -> Operator.PLUS.operate(first, second)
        Operator.MINUS -> Operator.MINUS.operate(first, second)
        Operator.MULTIPLY -> Operator.MULTIPLY.operate(first, second)
        Operator.DIVIDE -> Operator.DIVIDE.operate(first, second)
    }

    fun calculateString(input: String?): Int {
        val inputs = input?.split(" ")
        require(!inputs.isNullOrEmpty())
        var result = inputs[0].toInt()

        inputs.drop(INPUTS_FIRST_VALUE).windowed(size = ARRAY_SIZE, step = INTERVAL_SIZE, partialWindows = true)
            .forEach {
                if (it.size != ARRAY_SIZE) throw IllegalArgumentException()
                result = calculate(first = result, symbol = it[0], second = it[1].toInt())
            }
        return result
    }
}
