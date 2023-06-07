package study.step2.calculate

import org.apache.commons.lang3.StringUtils

class Calculator {

    private var symbol: String = OperationSymbol.initPlusSymbol()
    private var result = 0

    fun calculate(targetStr: String?): Int {
        if (StringUtils.isBlank(targetStr)) throw IllegalArgumentException("문자열을 null 이거나 빈 문자열일 수 없습니다.")

        initCalculator()
        targetStr!!.split(" ").map(this::dealEachSymbol)

        return result
    }

    private fun initCalculator() {
        symbol = OperationSymbol.initPlusSymbol()
        result = 0
    }

    private fun dealEachSymbol(value: String) {
        when (val number = value.toIntOrNull()) {
            null -> changeSymbol(value)
            else -> operateBySymbol(symbol, number)
        }
    }

    private fun operateBySymbol(
        symbol: String,
        number: Int,
    ) {
        val operationSymbol = OperationSymbol.findBySymbol(symbol)
        result = operationSymbol.operate(result, number)
    }

    private fun changeSymbol(value: String) {
        symbol = OperationSymbol.findBySymbol(value).value
    }
}
