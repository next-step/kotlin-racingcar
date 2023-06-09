package step2.calculator

class TokenizedExpression(
    private val inputData: String
) : Expression {
    override fun generate(): List<String> = inputData.split(" ")
}
