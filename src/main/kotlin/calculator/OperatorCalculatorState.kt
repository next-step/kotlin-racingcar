package calculator

class OperatorCalculatorState(private val number: Int) : CalculatorState {
    override fun input(value: String): CalculatorState {
        val operator = Operator.from(value)
        return OperandCalculatorState(number, operator)
    }

    override fun result(): Int {
        return number
    }
}
