package calculator

class TestCalculator(operators: List<Operator>) : Calculator(operators) {

    override fun calculate(input: String?): Int = 0
}

class TestOperator : Operator {
    override val symbol: Symbol = Symbol("T")

    override fun operate(left: Int, right: Int): Int = 0
}
