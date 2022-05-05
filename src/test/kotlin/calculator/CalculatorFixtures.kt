package calculator

data class StringCalculatorFixture(
    val expression: String,
    val expected: Int
)

data class OperatorFixture(
    val symbol: String,
    val operator: Operator
)

data class OneSpaceExpressionFixture(
    val text: String,
    val separations: List<String>
)

data class OperationFixture(
    val first: Int,
    val second: Int,
    val expected: Int
)

data class ExpressionFixture(
    val numbers: List<Int>,
    val operators: List<Operator>,
    val expected: Int
)
