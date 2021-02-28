package calculator.domain

class Calculator(private val operands: List<Number>, private val operators: List<Operator>) {

    init {
        check(operands.size == operators.size + 1) { "숫자는 연산자보다 갯수가 1개 더 많아야 합니다" }
    }

    constructor(mathExpression: MathExpression) : this(mathExpression.extractOperands(), mathExpression.extractOperators())

    fun calculate(): Number {
        val mutableOperands = operands.toMutableList()
        val mutableOperators = operators.toMutableList()

        var result = mutableOperands.removeAt(0)

        while (mutableOperands.isNotEmpty()) {
            val oprtr = mutableOperators.removeAt(0)
            result = oprtr.operate(result, mutableOperands.removeAt(0))
        }

        return result
    }
}
