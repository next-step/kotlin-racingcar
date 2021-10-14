package calculator

import calculator.StringExtension.checkNullOrEmpty

class Calculator {
    fun calculate(input: String) : String {
        if (input.checkNullOrEmpty()) throw IllegalArgumentException()
        val list = InputParser.splitSpace(input)
        var result = list[0].toDouble()

        list.drop(0)
            .forEachIndexed { index, s ->
                if (index % 2 != 0) {
                    val operator = Operator.getOperatorEnum(s)
                    result = operator.execute(result, list[index + 1].toDouble())
                }
            }

        return result.toString()
    }
}
