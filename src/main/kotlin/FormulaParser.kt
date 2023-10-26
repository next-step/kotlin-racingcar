class FormulaParser {
    companion object {
        const val DIVISION_CHARACTER = ' '
    }

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
    }

    private fun validateNotBlank(formulaComponents: List<String>) {
        if (formulaComponents.filterNot { it.isBlank() }.isEmpty()) {
            throw IllegalArgumentException("입력 값이 공백입니다.")
        }
    }

    private fun validateFormulaStructure(formulaComponents: List<String>) {
        // 수식의 마지막은 숫자.
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
}
