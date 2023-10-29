package step2.calculator

/**
 * 문자열 계산기
 * */
object Calculator {

    private const val DELIMITER = " "

    enum class CalculatorSign(val signStr: String) {
        PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/")
    }

    private fun checkError(inputStr: String?) {

        val inputStrSplitList = inputStr?.split(DELIMITER) ?: emptyList()

        require(!inputStr.isNullOrEmpty()) {
            "Invalid Expression: $inputStr"
        }

        require(inputStrSplitList.all { it.isNotBlank() }) {
            "Invalid Expression: $inputStr"
        }

        require(isCheckIndexValue(inputStrSplitList)) {
            "Invalid Expression: $inputStr"
        }
    }

    private fun isCheckIndexValue(inputStrSplitList: List<String>): Boolean = inputStrSplitList.mapIndexed { index, s ->
        if (index % 2 == 0) {
            s.toIntOrNull() != null
        } else {
            CalculatorSign.values().any { sign -> sign.signStr == s }
        }
    }.all { it }

    /**
     * 계산 요청시 사용
     *
     * @param inputStr 계산에 사용할 문자열
     * @return 계산식을 이용해 얻은 결과 값
     * */
    fun calculate(inputStr: String?): Int {

        checkError(inputStr)

        val splitFormulaList = inputStr!!.split(DELIMITER)
        val numberList = splitFormulaList.filter { value -> value.toIntOrNull() != null }.map { it.toInt() }
        val signList = splitFormulaList.filter { value -> value.toIntOrNull() == null }

        var result = 0

        numberList.forEachIndexed { index, number ->
            result = if (index == 0) {
                number
            } else {
                unitCalculate(result, number, signList[index - 1])
            }
        }
        return result
    }

    private fun unitCalculate(num1: Int, num2: Int, sign: String): Int = when (sign) {
        CalculatorSign.PLUS.signStr -> num1 + num2
        CalculatorSign.MINUS.signStr -> num1 - num2
        CalculatorSign.MULTIPLY.signStr -> num1 * num2
        CalculatorSign.DIVIDE.signStr -> num1 / num2
        else -> throw IllegalArgumentException()
    }
}