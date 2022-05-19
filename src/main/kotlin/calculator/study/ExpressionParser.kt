package calculator.study

import calculator.dto.AbstractSyntaxTree
import calculator.ext.isNumeric

class ExpressionParser(private val expressionSyntaxChecker: ExpressionSyntaxChecker) {

    fun compile(expression: String): AbstractSyntaxTree {
        expressionSyntaxChecker.validate(expression)
        return parse(expression)
    }

    private fun parse(expression: String): AbstractSyntaxTree =
        expression
            .split(" ")
            .partition(String::isNumeric)
            .run {
                AbstractSyntaxTree(first, second)
            }
}
