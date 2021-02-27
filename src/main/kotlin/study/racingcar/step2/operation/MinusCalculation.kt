package study.racingcar.step2.operation

class MinusCalculation : AbstractCalculation() {
    override fun calc(leftValue: Int, rightValue: Int): Int {
        return leftValue - rightValue
    }
}
