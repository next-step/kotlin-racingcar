package calculation

class Calculation(expression: String) : MathNumber() {
    private val tokens: Tokens

    override val value: Number
        get() {
            val result = with(tokens) { BinaryOperation(operator)(leftHandSide, rightHandSide) }

            return if (tokens.exhausted) result else Calculation(result, tokens.nextExpression)
        }

    init {
        if (expression.empty()) {
            throw IllegalArgumentException()
        }
        this.tokens = Tokens(expression)
    }

    private constructor(
        number: Number,
        nextExpression: String
    ) : this("$number $nextExpression")

    private fun String.empty() = isEmpty()
}
