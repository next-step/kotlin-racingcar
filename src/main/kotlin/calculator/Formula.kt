package calculator

class Formula(private val formula: String) {

    val elements: List<String> = initElements()

    fun calculateFormula(): Int {
        return Calculator.calculate(this)
    }

    private fun initElements(): List<String> {
        formula.split(DELIMITER).let {
            validateFormula(it)
            return it
        }
    }

    private fun validateFormula(elements: List<String>) {

        for (i in elements.indices step 2) {
            validateOperand(elements[i])
        }

        if (elements.size % 2 == 0 || elements.size == 1) {
            throw IllegalArgumentException("수식의 형식이 잘못되었습니다.")
        }
    }

    private fun validateOperand(operand: String) {
        require(isNumeric(operand)) { "수식의 형식이 잘못되었습니다." }
    }

    private fun isNumeric(input: String): Boolean {
        return input.all { it.isDigit() }
    }

    companion object {
        private const val DELIMITER = " "
    }
}
