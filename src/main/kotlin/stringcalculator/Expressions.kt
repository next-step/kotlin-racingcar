package stringcalculator

interface Expression {
    fun evaluate(): Double
}

class PlusBinaryExpression(private val first: Expression, private val second: Expression) : Expression {
    override fun evaluate(): Double = first.evaluate() + second.evaluate()
}

class MinusBinaryExpression(private val first: Expression, private val second: Expression) : Expression {
    override fun evaluate(): Double = first.evaluate() - second.evaluate()
}

class DivideBinaryExpression(private val first: Expression, private val second: Expression) : Expression {
    override fun evaluate(): Double = first.evaluate() / second.evaluate()
}

class MultiplyBinaryExpression(private val first: Expression, private val second: Expression) : Expression {
    override fun evaluate(): Double = first.evaluate() * second.evaluate()
}

class UnaryExpression(private val value: String) : Expression {
    override fun evaluate(): Double = value.toDouble()
}
