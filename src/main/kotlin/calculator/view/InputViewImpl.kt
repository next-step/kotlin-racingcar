package calculator.view

class InputViewImpl(
    private val readlnOrNull: () -> String?
) : InputView {

    companion object {
        const val DELIMITER = " "
    }

    override fun inputFormula(): List<String> {
        println("수식을 입력해주세요.")
        val formula = readlnOrNull().let {
            if (it.isNullOrBlank()) {
                throw IllegalArgumentException("수식이 입력되지 않았습니다.")
            }
            it
        }
        val elements = formula.split(DELIMITER)

        validateFormula(elements)

        return elements
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
        if (!isNumeric(operand)) {
            throw IllegalArgumentException("수식의 형식이 잘못되었습니다.")
        }
    }

    private fun isNumeric(input: String): Boolean {
        return input.all { it.isDigit() }
    }
}
