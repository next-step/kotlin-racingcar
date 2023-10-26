package org.bmsk.calculator.validator

import org.bmsk.calculator.ErrorMessage.BLANK_FORMULA
import org.bmsk.calculator.ErrorMessage.EVEN_POSITION_MUST_BE_NUMBER
import org.bmsk.calculator.ErrorMessage.FORMULA_MUST_END_WITH_NUMBER
import org.bmsk.calculator.ErrorMessage.FORMULA_MUST_START_WITH_NUMBER
import org.bmsk.calculator.ErrorMessage.ODD_POSITION_MUST_BE_OPERATOR
import org.bmsk.calculator.model.StringFormula
import org.bmsk.calculator.util.isNumeric
import org.bmsk.calculator.util.isOperator

internal object StringFormulaValidator {

    fun validate(stringFormula: StringFormula) {
        validateIsNotBlank(stringFormula)
        stringFormula.formula.split(" ").let { tokens ->
            validateStartAndEnd(tokens)
            validateTokenSequence(tokens)
        }
    }

    private fun validateIsNotBlank(stringFormula: StringFormula) {
        require(stringFormula.formula.isNotBlank()) { BLANK_FORMULA }
    }

    private fun validateStartAndEnd(tokens: List<String>) {
        if (!tokens.first().isNumeric()) {
            throw IllegalArgumentException(FORMULA_MUST_START_WITH_NUMBER)
        }
        if (!tokens.last().isNumeric()) {
            throw IllegalArgumentException(FORMULA_MUST_END_WITH_NUMBER)
        }
    }

    private fun validateTokenSequence(tokens: List<String>) {
        tokens.forEachIndexed { index, token ->
            if (index % 2 == 0 && !token.isNumeric()) {
                throw IllegalArgumentException(EVEN_POSITION_MUST_BE_NUMBER)
            } else if (index % 2 == 1 && !token.isOperator()) {
                throw IllegalArgumentException(ODD_POSITION_MUST_BE_OPERATOR)
            }
        }
    }
}
