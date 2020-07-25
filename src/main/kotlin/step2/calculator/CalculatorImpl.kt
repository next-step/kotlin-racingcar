package step2.calculator

import step2.util.subListStartWith

class CalculatorImpl : Calculator {
    /**
     * Node List를 순차적으로 계산한다.
     * 앞에서부터 연산자 하나씩 뽑아서 계산하고 결과를 다시 넣은 다음
     * 나머지 목록과 함께 재귀적으로 계산한다.
     */
    override fun calculate(input: List<Node>): Int {
        val left: Node.Number = input.getNumber(0)
        if (input.size == 1) {
            return left.value.toInt()
        }
        val operator = input.getOperator(1)
        val right = input.getNumber(2)
        return calculate(input.subListStartWith(operator.operate(left, right), 3))
    }

    /**
     * Node.Number를 추출한다.
     * 인덱스가 잘못되었거나 Operator가 들어있다면 NumberIsMissing 을 던진다.
     */
    fun List<Node>.getNumber(index: Int): Node.Number {
        if (index in 0 until size &&
            get(index) is Node.Number
        ) {
            return get(index) as Node.Number
        }
        throw Calculator.Error.NumberIsMissing
    }

    /**
     * Node.Operator를 추출한다.
     * 인덱스가 잘못되었거나 Number가 들어있다면 NumberIsMissing 을 던진다.
     */
    fun List<Node>.getOperator(index: Int): Node.Operator {
        if (index in 0 until size &&
            get(index) is Node.Operator
        ) {
            return get(index) as Node.Operator
        }
        throw Calculator.Error.OperatorIsMissing
    }
}
