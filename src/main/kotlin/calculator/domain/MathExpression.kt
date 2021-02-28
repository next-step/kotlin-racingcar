package calculator.domain

interface MathExpression {

    fun extractOperators(): List<Operator>

    fun extractOperands(): List<Number>
}
