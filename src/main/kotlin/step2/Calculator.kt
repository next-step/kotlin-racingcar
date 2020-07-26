package step2

import java.lang.IllegalArgumentException

class Calculator {

    fun preWork(string: String) {

        // data split
        val splitString = CalculatorUtil.dataSplit(string)

        // 유효성 검사
        CalculatorUtil.validate(splitString)

        calculate(splitString)
    }

    fun calculate(splitString: List<String>): Int {
        var result = 0

        for (i in 0..splitString.lastIndex - 2 step 2) {
            val parser = CalculatorUtil.parser(i, splitString).toMutableList()

            if (i > 0) {
                parser[0] = result.toString()
            }
            result = calc(parser)
        }

        return result
    }

    private fun calc(list: List<String>): Int {
        return when (list[1]) {
            Operator.PLUS.getOperand() -> Operator.PLUS.apply(list[0].toInt(), list[2].toInt())
            Operator.MINUS.getOperand() -> Operator.MINUS.apply(list[0].toInt(), list[2].toInt())
            Operator.TIMES.getOperand() -> Operator.TIMES.apply(list[0].toInt(), list[2].toInt())
            Operator.DIV.getOperand() -> Operator.DIV.apply(list[0].toInt(), list[2].toInt())
            else -> throw IllegalArgumentException("잘못된 연산자입니다")
        }
    }
}
