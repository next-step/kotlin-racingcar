package calculator

class Formula(private val formula: String) {

    private val elements: List<String> = initElements()

    fun calculateFormula(): Int {
        return Calculator.calculate(elements)
    }

    private fun initElements(): List<String> {
        formula.split(DELIMITER).let {
            ValidationFormula.validateFormula(it)
            return it
        }
    }

    companion object {
        private const val DELIMITER = " "
    }
}
