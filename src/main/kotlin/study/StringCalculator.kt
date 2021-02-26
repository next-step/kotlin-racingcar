package study

import java.lang.IllegalArgumentException

object StringCalculator {
    fun calculate(targetStr: String?): Int {

        if (targetStr == null || targetStr.isBlank()) {
            throw IllegalArgumentException("연산 대상 문자열이 null 또는 빈 값입니다.")
        }

        val targetArr = targetStr.split(" ")

        var value = Integer.valueOf(targetArr[0])

        for (operatorIndex in 1 until targetArr.size - 1 step 2) {
            val nextNum = Integer.valueOf(targetArr[operatorIndex + 1])
            value = calculateByOperator(value, targetArr[operatorIndex], nextNum)
        }

        return value
    }

    private fun calculateByOperator(preNum: Int, operator: String, nextNum: Int): Int {
        return when (operator) {
            "+" -> preNum + nextNum
            "-" -> preNum - nextNum
            "*" -> preNum * nextNum
            "/" -> preNum / nextNum
            else -> throw IllegalArgumentException("잘못된 연산자가 포함되어 있습니다.")
        }
    }
}
