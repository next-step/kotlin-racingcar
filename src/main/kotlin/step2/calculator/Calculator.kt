package step2.calculator

/**
 * 문자열 계산기
 * */
object Calculator {

    private const val DELIMITER = " "

    enum class CalculatorSign(val signStr: String) {
        PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

        /**
         * 숫자 두개와 부호로 계산한 값을 반환
         *
         * @param num1 입력 값1
         * @param num2 입력 값2
         * @return 계산된 값
         * */
        fun calculate(num1: Int, num2: Int): Int = when (this) {
            PLUS -> num1 + num2
            MINUS -> num1 - num2
            MULTIPLY -> num1 * num2
            DIVIDE -> num1 / num2
        }
    }

    private fun checkError(splitFormulaList: List<String>) {

        require(splitFormulaList.isNotEmpty()) {
            "Invalid Expression: $splitFormulaList"
        }

        require(splitFormulaList.all { it.isNotBlank() }) {
            "Invalid Expression: $splitFormulaList"
        }

        require(isCheckIndexValue(splitFormulaList)) {
            "Invalid Expression: $splitFormulaList"
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

        val splitFormulaList: List<String> = inputStr!!.split(DELIMITER)

        checkError(splitFormulaList)

        val numberList = splitFormulaList.filter { value -> value.toIntOrNull() != null }.map { it.toInt() }
        val signList = splitFormulaList.filter { value -> value.toIntOrNull() == null }

        var result = 0

        numberList.forEachIndexed { index, number ->
            result = if (index == 0) {
                number
            } else {
                val calculatorSign = CalculatorSign.values().first { it.signStr == signList[index - 1] }
                calculatorSign.calculate(result, number)
            }
        }
        return result
    }
}