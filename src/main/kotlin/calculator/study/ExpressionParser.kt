package calculator.study

import calculator.dto.AST
import calculator.ext.isNumeric

object ExpressionParser {

    fun compile(expression: String): CalculateMachine {
        CalcSyntaxChecker.validate(expression)
        return createCalculateMachine(expression)
    }

    private fun createCalculateMachine(expression: String): CalculateMachine = CalculateMachine(parse(expression))

    private fun parse(expression: String): AST =
        expression
            .split(" ")
            .partition(String::isNumeric)
            .run {
                AST(this.first, this.second)
            }
}
