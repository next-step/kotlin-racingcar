package study.racingcar.step2.operation

class MultiplicationCalculation : AbstractCalculation() {
    override fun calc(leftValue: Int, rightValue: Int): Int {
        return leftValue * rightValue
    }
}
