package stringcalculator

interface Expression {
    fun evaluate(): Double
}

class BinaryExpression(
    private val first: Expression,
    private val operator: Operator,
    private val second: Expression
) : Expression {
    override fun evaluate(): Double = operator(first.evaluate(), second.evaluate())
}

class NumberExpression(private val value: String) : Expression {
    override fun evaluate(): Double = value.toDouble()
}
