package study.step2.calculate

import org.apache.commons.lang3.StringUtils

class Calculator(
    private val calculateOperation: CalculateOperation
) {
    private var symbol = "+"
    fun calculate(targetStr: String?): Int {
        if (StringUtils.isBlank(targetStr)) throw IllegalArgumentException("문자열을 null 이거나 빈 문자열일 수 없습니다.")
        initCalculator()
        targetStr!!.split(" ")
            .map(this::dealEachSymbol)

        return calculateOperation.getResult()
    }

    private fun initCalculator() {
        symbol = "+"
        calculateOperation.initOperation()
    }

    private fun dealEachSymbol(value: String) {
        when (val number = value.toIntOrNull()) {
            null -> changeSymbol(value)
            else -> calculateOperation.operateBySymbol(symbol, number)
        }
    }

    private fun changeSymbol(value: String) {
        if (value in calculateOperation.getKeys()) {
            symbol = value
        } else {
            throw IllegalArgumentException("${value}는 사칙연산 기호가 아닙니다.")
        }
    }
}
