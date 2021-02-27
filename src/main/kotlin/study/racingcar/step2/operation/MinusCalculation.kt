package study.racingcar.step2.operation

class MinusCalculation : AbstractCalculation() {
    internal override fun calculate(leftValue: Int, rightValue: Int): Int {
        return leftValue - rightValue
    }
}
