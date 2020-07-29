package step2.calculator

import step2.util.isOdd

class CalculatorImpl : Calculator {
    /**
     * Node List를 순차적으로 계산한다.
     */
    override fun calculate(input: List<Node>): Int {
        var indexOperator = 1
        var indexRight = 2
        var sum = input.getNumber(0)

        while (indexRight != input.size + 1) {
            val left = sum
            val operator = input.getOperator(indexOperator)
            val right = input.getNumber(indexRight)
            sum = operator.operate(left, right)

            indexRight += 2
            indexOperator += 2
        }
        return sum.value.toInt()
    }

    /**
     * Node.Number를 추출한다.
     * 인덱스가 잘못되었거나 Operator가 들어있다면 NumberIsMissing 을 던진다.
     */
    fun List<Node>.getNumber(index: Int): Node.Number {
        val node = getOrNull(index)
        if (node !is Node.Number) {
            throw Calculator.Error.NumberIsMissing
        }
        return node
    }

    /**
     * Node.Operator를 추출한다.
     * 인덱스가 잘못되었거나 Number가 들어있다면 NumberIsMissing 을 던진다.
     */
    fun List<Node>.getOperator(index: Int): Node.Operator {
        val node = getOrNull(index)
        if (node !is Node.Operator) {
            throw Calculator.Error.OperatorIsMissing
        }
        return node
    }

    fun List<Node>.filterOnlyOdd() = filterIndexed { index, _ -> index.isOdd() }
    fun List<Node>.filterOnlyEven() = filterIndexed { index, _ -> !index.isOdd() }
}
