package calculator

interface BinaryOperator {

    fun canHandle(literal: String): Boolean

    fun evaluate(left: Expression, right: Expression): Double
}

object Plus : BinaryOperator {

    private const val PLUS = "+"

    override fun canHandle(literal: String) = (literal == PLUS)

    override fun evaluate(left: Expression, right: Expression): Double {
        return left.evaluate() + right.evaluate()
    }
}

object Minus : BinaryOperator {

    private const val MINUS = "-"

    override fun canHandle(literal: String) = (literal == MINUS)

    override fun evaluate(left: Expression, right: Expression): Double {
        return left.evaluate() - right.evaluate()
    }
}

object Multiply : BinaryOperator {

    private const val MULTIPLY = "*"

    override fun canHandle(literal: String) = (literal == MULTIPLY)

    override fun evaluate(left: Expression, right: Expression): Double {
        return left.evaluate() * right.evaluate()
    }
}

object Divide : BinaryOperator {

    private const val DIVIDE = "/"
    private const val ZERO = 0.0

    override fun canHandle(literal: String) = (literal == DIVIDE)

    override fun evaluate(left: Expression, right: Expression): Double {
        val leftEvaluated = left.evaluate()
        val rightEvaluated = right.evaluate()
        require(rightEvaluated != ZERO) { "나누는 값은 0이 될 수 없습니다" }
        return leftEvaluated / rightEvaluated
    }
}
