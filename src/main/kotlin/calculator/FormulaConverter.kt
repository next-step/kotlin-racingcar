package calculator

import calculator.Operand.Companion.toOperand

class FormulaConverter {
    fun convert(formula: String): FormulaElements {
        formula.shouldValidInput()

        return FormulaElements(formula.split(formulaDelimiter))
    }

    private fun String.shouldValidInput() = Validator.checkValidInputOrThrows(this)

    object Validator {
        fun checkValidInputOrThrows(formula: String) {
            require(formula.isNotEmpty())
        }
    }

    companion object {
        private const val formulaDelimiter = " "
    }
}

typealias Calculation = (leftOperand: Operand, rightOperand: Operand) -> Operand

enum class Operation(val symbol: String, val calculation: Calculation) {
    PLUS(
        "+",
        { leftOperand, rightOperand -> (leftOperand.value + rightOperand.value).toOperand() }
    ),
    MINUS(
        "-",
        { leftOperand, rightOperand -> (leftOperand.value - rightOperand.value).toOperand() }
    ),
    MULTIPLY(
        "*",
        { leftOperand, rightOperand -> (leftOperand.value * rightOperand.value).toOperand() }
    ),
    DIVIDER(
        "/",
        { leftOperand, rightOperand -> (leftOperand.value / rightOperand.value).toOperand() }
    );

    companion object {
        fun of(operation: String): Operation? = values().find { it.symbol == operation }
    }
}
