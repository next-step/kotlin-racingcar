package calculator

object ValidationFormula {

    fun validateFormula(elements: List<String>) {

        for (i in elements.indices) {
            if (i % 2 == 0) {
                validateOperand(elements[i])
            } else {
                validateOperator(elements[i])
            }
        }

        if (elements.size % 2 == 0 || elements.size == 1) {
            throw IllegalArgumentException("수식의 형식이 잘못되었습니다.")
        }
    }

    private fun validateOperator(operator: String) {
        require(Operator.isOperator(operator)) { "수식의 형식이 잘못되었습니다." }
    }

    private fun validateOperand(operand: String) {
        require(isNumeric(operand)) { "수식의 형식이 잘못되었습니다." }
    }

    private fun isNumeric(input: String): Boolean {
        return input.all { it.isDigit() }
    }
}
