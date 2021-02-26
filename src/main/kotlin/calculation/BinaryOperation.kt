package calculation

class BinaryOperation(private val operator: String) {
    companion object {
        val operators: Map<String, (String, String) -> Number> = mapOf(
            "+" to ::Sum,
            "-" to ::Difference,
            "*" to ::Product,
            "/" to ::Quotient
        )
    }

    init {
        if (operator !in operators.keys) {
            throw IllegalArgumentException()
        }
    }

    operator fun invoke(leftHandSide: String, rightHandSide: String) =
        operators[operator]!!(leftHandSide, rightHandSide)
}
