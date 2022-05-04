package step2.calculator

class Calculation(
    private val operator: Operator,
    private val number: Double
) {
    fun applyTo(accumulator: Double) = operator.operate(accumulator, number)
}

infix fun Double.compensates(calculation: Calculation): Double {
    return calculation.applyTo(this)
}