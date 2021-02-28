package calculator.domain

import calculator.isEven
import calculator.isOdd

class BlankMathExpression(private val input: String) : MathExpression {

    private val mathExpressionDelimiter = " "

    override fun extractOperators(): List<Operator> {
        return input.split(mathExpressionDelimiter)
            .filterIndexed { idx, _ -> idx.isOdd() }
            .map { Operator.from(it) }
    }

    override fun extractOperands(): List<Number> {
        return input.split(mathExpressionDelimiter)
            .filterIndexed { idx, _ -> idx.isEven() }
            .map { Number(it) }
    }
}
