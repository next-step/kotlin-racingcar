package calculator

private const val DELIMITER = " "

/**
 * 문자열 계산기
 * */
object Calculator {

    enum class CalculatorSign(val sign: String, val calculate: (Int, Int) -> Int) {
        PLUS("+", { num1, num2 -> num1 + num2 }),
        MINUS("-", { num1, num2 -> num1 - num2 }),
        MULTIPLY("*", { num1, num2 -> num1 * num2 }),
        DIVIDE("/", { num1, num2 -> num1 / num2 });

        companion object {
            /**
             * 텍스트 CalculatorSign 변환
             * */
            fun from(signText: String): CalculatorSign {
                return CalculatorSign.values().first { sign -> signText == sign.sign }
            }
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
     * @param formulaText 텍스트 계산식
     * @return 계산식을 이용해 얻은 결과 값
     * */
    fun calculate(formulaText: String?): Int {

        val splitFormulaList: List<String> = formulaText?.split(DELIMITER) ?: emptyList()

        checkError(splitFormulaList)

        val (operandsDeque, operatorsDeque) =
            splitFormulaList.foldIndexed(ArrayDeque<String>() to ArrayDeque<String>()) { index, (operands, operators), item ->
                if (index % 2 == 0) {
                    operands.add(item)
                } else {
                    operators.add(item)
                }
                operands to operators
            }

        return operatorsDeque.foldIndexed(operandsDeque.first().toInt()) { index, sum, operator ->
            CalculatorSign.from(operator).calculate(sum, operandsDeque[index + 1].toInt())
        }
    }
}