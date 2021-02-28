package study.calculator

import kotlin.IllegalArgumentException

object StringCalculator {

    private const val STRING_DELIMETER = " "
    private const val INDEX_OF_FIRST_VALUE = 0

    fun calculate(targetStr: String): Int {

        val elements = splitInput(targetStr)
        var calculateResult = getFirstNum(elements)

        for (operatorIndex in 1 until elements.size step 2) {

            val nextNumIndex = operatorIndex + 1
            val operator = getOperator(elements, operatorIndex)
            val nextNum = getOperandNum(elements, nextNumIndex)

            calculateResult = operator.calculate(calculateResult, nextNum)
        }

        return calculateResult
    }

    private fun splitInput(targetStr: String?): List<String> {

        require(!targetStr.isNullOrBlank()) {"문자열이 null 또는 빈 값입니다."}

        return targetStr.split(STRING_DELIMETER)
    }

    private fun getFirstNum(elements: List<String>): Int {
        return getOperandNum(elements, INDEX_OF_FIRST_VALUE)
    }

    private fun getOperator(elements: List<String>, operatorIndex: Int): Operator {
        return Operator.findBySymbol(elements[operatorIndex]) ?: throw IllegalArgumentException("${elements[operatorIndex]}는 존재하지 않는 연산자입니다.")
    }

    private fun getOperandNum(elements: List<String>, operandIndex: Int): Int {

        require(operandIndex < elements.size) {"피연산자가 존재하지 않습니다."}

        return convertStringToNum(elements[operandIndex])
    }

    private fun convertStringToNum(strNumber: String): Int {
        return strNumber.toIntOrNull() ?: throw IllegalArgumentException("잘못된 문자열이 피연산자로 입력되었습니다.")
    }
}
