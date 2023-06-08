package calculator.domain

import calculator.utils.CalculatorParser

class Calculator {

    private val inputValidator: InputValidator = InputValidator()

    fun run(input: String?) {
        val validatedInput = inputValidator.validate(input)
        val extractedList = CalculatorParser.extract(validatedInput)
        val result = calculate(extractedList)
        println(result)
    }

    /**
     * 추출한 문자열 계산
     */
    fun calculate(list: List<String>): Double {

        var result = list[0].toDouble()

        for (i in 1 until list.size step 2) {
            val operator = Operator.findOperate(list[i])
            result = operator.operate(result, list[i + 1].toDouble())
        }

        return result
    }
}
