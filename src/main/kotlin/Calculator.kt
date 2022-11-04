data class Calculator(private val value: String) {
    fun operate(beforeOperator: Operator, value: Calculator): Calculator {
        return when (beforeOperator) {
            Operator.ADD -> Calculator(this.value.toInt().plus(value.value.toInt()).toString())
            Operator.MINUS -> Calculator(this.value.toInt().minus(value.value.toInt()).toString())
            Operator.TIMES -> Calculator(this.value.toInt().times(value.value.toInt()).toString())
            Operator.DIV -> Calculator(this.value.toInt().div(value.value.toInt()).toString())
        }
    }
}
