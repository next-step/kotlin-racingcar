package calculator

internal class CalculatorInput(
    val operands: List<Double>,
    val operators: List<Operator>,
) {
    init {
        require(operands.size == operators.size + 1) {
            "Number of operands should be one more than number of operators."
        }
    }
}
