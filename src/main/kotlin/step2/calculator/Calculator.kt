package step2.calculator

/**
 * 문자열 계산기
 *
 * 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
 * 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
 * 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 *
 * @since 2023/10/23
 * @author KimJungSik
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