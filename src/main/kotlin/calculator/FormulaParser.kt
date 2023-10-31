package calculator

object FormulaParser {

    private const val DIVISION_CHARACTER = ' '
    private const val OPERATOR_STEP = 2
    private const val OPERAND_STEP = 1
    private const val DIVISION_SYMBOL = "/"
    private const val ZERO = "0"
    fun parse(formula: String): List<String> {
        val formulaComponents = splitFormula(formula)

        validateFormula(formulaComponents)

        return formulaComponents
    }

    private fun splitFormula(formula: String) = formula.split(DIVISION_CHARACTER)

    private fun validateFormula(formulaComponents: List<String>) {
        validateNotBlank(formulaComponents)
        validateFormulaStructure(formulaComponents)
        validateNumbers(formulaComponents)
        validateOperators(formulaComponents)
        validateDivisionByZero(formulaComponents)
    }

    private fun validateNotBlank(formulaComponents: List<String>) {
        // 공백 검증.
        if (formulaComponents.all { it.isBlank() }) {
            throw IllegalArgumentException("입력 값이 공백입니다.")
        }
    }

    private fun validateFormulaStructure(formulaComponents: List<String>) {
        // 수식 구성 검증
        if (formulaComponents.size % 2 == 0) {
            throw IllegalArgumentException("수식의 구성이 잘못됐습니다.")
        }
    }

    private fun validateNumbers(formulaComponents: List<String>) {
        // 숫자 검증
        for (i in formulaComponents.indices step 2) {
            if (formulaComponents[i].toIntOrNull() == null) throw NumberFormatException("피연산자 항목이 숫자가 아닙니다.")
        }
    }

    private fun validateOperators(formulaComponents: List<String>) {
        // 연산자 검증
        for (i in 1 until formulaComponents.size step 2) {
            Operator.from(formulaComponents[i])
        }
    }

    private fun validateDivisionByZero(formulaComponents: List<String>) {
        // / 0 방지
        formulaComponents.withIndex()
            .filter { it.index % OPERATOR_STEP == 1 }
            .forEach { checkZeroDivision(it.value, formulaComponents[it.index + OPERAND_STEP]) }
    }

    private fun checkZeroDivision(operator: String, operand: String) {
        if (operator == DIVISION_SYMBOL && operand == ZERO) {
            throw IllegalArgumentException("/ 0은 할 수 없습니다.")
        }
    }
}
