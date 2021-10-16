package calculator

interface Expression {
    fun evaluate(): Double
}

class BinaryExpression(
    private val left: Expression,
    private val operator: String,
    private val right: Expression
) : Expression {

    override fun evaluate(): Double {
        return when (operator) {
            "+" -> left.evaluate() + right.evaluate()
            "-" -> left.evaluate() - right.evaluate()
            "*" -> left.evaluate() * right.evaluate()
            "/" -> left.evaluate() / right.evaluate()
            else -> throw IllegalArgumentException()
        }
    }
}

class NumberExpression(private val value: Double) : Expression {

    constructor(value: String) : this(value.toDouble())

    override fun evaluate(): Double {
        return value
    }
}
