package step2

import java.lang.IllegalArgumentException

class Calculator {
    private val checker: CalculatorChecker = CalculatorChecker()
    fun calculate(input: Input): Int {
        val formulaList = input.text!!.split(Regex("\\s+"))
        val (numberList, arithmeticList) = splitList(formulaList)

        return operate(numberList, arithmeticList)
    }

    private fun splitList(formulaList: List<String>): Pair<List<Int>, List<Arithmetic>> {
        if (!checker.isFormulaValid(formulaList)) throw IllegalArgumentException()

        val numberList = mutableListOf<Int>()
        val arithmeticList = mutableListOf<Arithmetic>()
        formulaList.forEachIndexed { index, str ->
            if (checker.isEven(index))
                numberList.add(str.toInt())
            else
                arithmeticList.add(Arithmetic.values().find { str == it.expr }!!)
        }

        return Pair(numberList, arithmeticList)
    }


    private fun operate(numberList: List<Int>, arithmeticList: List<Arithmetic>): Int {
        var result = numberList[0]

        val expressionCount = arithmeticList.size
        for (i in 0 until expressionCount) {
            val operand = numberList[i + 1]
            result = when (arithmeticList[i]) {
                Arithmetic.PLUS -> result.add(operand)
                Arithmetic.MINUS -> result.subtract(operand)
                Arithmetic.TIMES -> result.multiply(operand)
                Arithmetic.DIVIDE -> result.divide(operand)
            }
        }

        return result
    }

    private fun Int.add(num: Int): Int {
        return this + num
    }

    private fun Int.subtract(num: Int): Int {
        return this - num
    }

    private fun Int.multiply(num: Int): Int {
        return this * num
    }

    private fun Int.divide(num: Int): Int {
        return this / num
    }
}
