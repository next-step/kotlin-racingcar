package calculator.calculator

class TextCalculator : Calculator {
    /**
     * Node List를 순차적으로 계산한다.
     */
    override fun calculate(input: List<Node>): Int {
        var sum = input.getNumber(0)
        for (index in 1 until input.size step 2) {
            val operator = input.getOperator(index)
            val number = input.getNumber(index + 1)
            sum = operator.operate(sum, number)
        }
        return sum.value.toInt()
    }

    /**
     * Number를 추출한다.
     * 인덱스가 잘못되었거나 Operator가 들어있다면 NumberIsMissing 을 던진다.
     */
    fun List<Node>.getNumber(index: Int): Number {
        val node = getOrNull(index)
        if (node !is Number) {
            throw Calculator.Error.NumberIsMissing
        }
        return node
    }

    /**
     * Operator를 추출한다.
     * 인덱스가 잘못되었거나 Number가 들어있다면 NumberIsMissing 을 던진다.
     */
    fun List<Node>.getOperator(index: Int): Operator {
        val node = getOrNull(index)
        if (node !is Operator) {
            throw Calculator.Error.OperatorIsMissing
        }
        return node
    }
}
