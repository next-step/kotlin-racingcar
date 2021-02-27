package calculation

class BinaryOperation(private val operator: String) {
    init {
        require(operator in operators.keys)
    }

    operator fun invoke(leftHandSide: String, rightHandSide: String) =
        operators[operator]!!(leftHandSide, rightHandSide)

    companion object {
        val operators: Map<String, (String, String) -> Number> = mapOf(
            "+" to ::Sum,
            "-" to ::Difference,
            "*" to ::Product,
            "/" to ::Quotient
        )
    }
}
