package calculator

interface Expression {
    fun evaluate(): Double
}

class BinaryExpression(
    private val left: Expression,
    private val operator: BinaryOperator,
    private val right: Expression,
) : Expression {

    override fun evaluate(): Double {
        return operator.evaluate(left, right)
    }
}

class NumberExpression(private val value: Double) : Expression {

    constructor(value: String) : this(value.toDouble())

    override fun evaluate(): Double {
        return value
    }
}

private fun String.toDouble(): Double {
    return toDoubleOrNull() ?: throw IllegalArgumentException("${this}는 실수가 아닙니다.")
}
