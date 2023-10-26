package calculator

class OperandCalculatorState(private val value: Int, private val operator: Operator) : CalculatorState {

    override fun input(value: String): CalculatorState {
        val number = NumberParser.parse(value)
        return OperatorCalculatorState(operator.operation(this.value, number))
    }

    override fun result(): Int {
        throw IllegalStateException("수식이 완성되지 않았습니다.")
    }
}
