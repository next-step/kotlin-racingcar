package calculator

import calculator.enums.OperatorSign

class Calculator(
    val inputData: String
) {
    private var result = 0
    private val numberList: MutableList<Int> = mutableListOf()
    private val signList: MutableList<String> = mutableListOf()

    private fun checkInputDataIsNullOrBlank(inputData: String): Boolean {
        return inputData.isNullOrBlank()
    }

    private fun checkIsNotSign(sign: String): Boolean {
        return (sign == OperatorSign.SUM.code || sign == OperatorSign.SUBSTRACT.code || sign == OperatorSign.MULTIPLY.code || sign == OperatorSign.DIVIDE.code)
    }
    private fun splitNumberAndSign(inputData: String) {
        val splitDatas = inputData.split(" ")

        splitDatas.forEach { splitData ->
            kotlin.runCatching {
                numberList.add((splitData.toInt()))
            }.onFailure { signList.add(splitData) }
        }
    }

    fun calculate(): Int {
        // check(), require()을 통해 제한을 걸 수 있다.
        require(!checkInputDataIsNullOrBlank(inputData)) {
            "입력값이 null 이거나 공백 입니다."
        }

        splitNumberAndSign(inputData)

        for (i in 0 until numberList.size) {
            if (i == 0) {
                result = numberList.get(i)
                continue
            }
            result = checkSignAndCalculate(signList.get(i - 1), result, numberList.get(i))
        }
        return result
    }

    private fun checkSignAndCalculate(sign: String, number1: Int, number2: Int): Int {
        require(checkIsNotSign(sign)) {
            "사칙연산의 기호가 아닙니다."
        }
        val operatorSign = OperatorSign.values().find { it.name == sign }!!
        return operatorSign.calculate(number1, number2)
    }
}
