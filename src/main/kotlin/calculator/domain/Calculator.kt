package calculator.domain

import calculator.io.Console
import calculator.utils.CalculatorParser

class Calculator {

    private val console: Console = Console()

    fun run() {
        val input = console.getInput()
        val extractedList = CalculatorParser.extract(input)
        val result = calculate(extractedList)
        println(result)
    }


    /**
     * 추출한 문자열 계산
     */
    fun calculate(list: List<String>): Double {

        var result = list[0].toDouble()

        for (i in 1 until list.size step 2) {
            val operator = Operator.findOperate(list[i][0])
            result = operator.operate(result, list[i + 1].toDouble())
        }

        return result
    }
}
