package calculator

interface BinaryOperator {

    fun canHandle(literal: String): Boolean

    fun evaluate(left: Expression, right: Expression): Double
}

object Plus : BinaryOperator {

    override fun canHandle(literal: String) = (literal == "+")

    override fun evaluate(left: Expression, right: Expression): Double {
        return left.evaluate() + right.evaluate()
    }
}

object Minus : BinaryOperator {

    override fun canHandle(literal: String) = (literal == "-")

    override fun evaluate(left: Expression, right: Expression): Double {
        return left.evaluate() - right.evaluate()
    }
}

object Multiply : BinaryOperator {

    override fun canHandle(literal: String) = (literal == "*")

    override fun evaluate(left: Expression, right: Expression): Double {
        return left.evaluate() * right.evaluate()
    }
}

object Divide : BinaryOperator {

    override fun canHandle(literal: String) = (literal == "/")

    override fun evaluate(left: Expression, right: Expression): Double {
        return left.evaluate() / right.evaluate()
    }
}
