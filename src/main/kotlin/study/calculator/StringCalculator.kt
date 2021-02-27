package study.calculator

import kotlin.IllegalArgumentException

object StringCalculator {

    private const val STRING_DELIMETER = " "

    fun calculate(targetStr: String?): Int {

        val elements = splitInput(targetStr)
        var calculateResult = getFirstNum(elements)

        for (operatorIndex in 1 until elements.size step 2) {

            val nextNumIndex = operatorIndex + 1
            val operator = getOperator(elements, operatorIndex)
            val nextNum = getNextNum(elements, nextNumIndex)

            calculateResult = operator.calculate(calculateResult, nextNum)
        }

        return calculateResult
    }

    private fun splitInput(targetStr: String?): List<String> {

        if (targetStr.isNullOrBlank()) {
            throw IllegalArgumentException("문자열이 null 또는 빈 값입니다.")
        }

        return targetStr.split(STRING_DELIMETER)
    }

    private fun getFirstNum(elements: List<String>): Int {
        return convertStringToNum(elements[0])
    }

    private fun getOperator(elements: List<String>, operatorIndex: Int): Operator {
        return Operator.findBySymbol(elements[operatorIndex])
    }

    private fun getNextNum(elements: List<String>, nextNumIndex: Int): Int {
        if (nextNumIndex >= elements.size) {
            throw IllegalArgumentException("피연산자가 존재하지 않습니다.")
        }
        return convertStringToNum(elements[nextNumIndex])
    }

    private fun convertStringToNum(strNumber: String): Int {
        if(!isNumber(strNumber)) {
            throw IllegalArgumentException("잘못된 문자열이 피연산자로 입력되었습니다.")
        }
        return Integer.valueOf(strNumber)
    }

    private fun isNumber(str: String): Boolean {
        return str.all { Character.isDigit(it) }
    }
}
