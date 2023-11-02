package step2.calculator

private const val DELIMITER = " "

/**
 * 문자열 계산기
 * */
object Calculator {

    enum class CalculatorSign(val sign: String) {
        PLUS("+") {
            override fun calculate(num1: Int, num2: Int): Int = num1 + num2
        },
        MINUS("-") {
            override fun calculate(num1: Int, num2: Int): Int = num1 - num2
        },
        MULTIPLY("*") {
            override fun calculate(num1: Int, num2: Int): Int = num1 * num2
        },
        DIVIDE("/") {
            override fun calculate(num1: Int, num2: Int): Int = num1 / num2
        };

        /**
         * 숫자 두개와 부호로 계산한 값을 반환
         *
         * @param num1 입력 값1
         * @param num2 입력 값2
         * @return 계산된 값
         * */
        abstract fun calculate(num1: Int, num2: Int): Int
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

    private fun isCheckIndexValue(inputStrSplitList: List<String>): Boolean =
        inputStrSplitList.mapIndexed { index, value ->
            if (index % 2 == 0) {
                value.toIntOrNull() != null
            } else {
                CalculatorSign.values().any { sign -> sign.sign == value }
            }
        }.all { it }

    /**
     * 계산 요청시 사용
     *
     * @param inputStr 계산에 사용할 문자열
     * @return 계산식을 이용해 얻은 결과 값
     * */
    fun calculate(inputStr: String?): Int {

        val splitFormulaList: List<String> = inputStr?.split(DELIMITER) ?: emptyList()

        checkError(splitFormulaList)

        val splitFormulaPair = splitFormulaList.partition { it.toIntOrNull() != null }

        return splitFormulaPair.second.zip(splitFormulaPair.first.drop(1))
            .fold(splitFormulaPair.first.first().toInt()) { acc, pair ->
                CalculatorSign.values().first { sign -> pair.first == sign.sign }.calculate(acc, pair.second.toInt())
            }
    }
}