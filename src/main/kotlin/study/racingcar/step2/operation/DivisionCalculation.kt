package study.racingcar.step2.operation

internal class DivisionCalculation : AbstractCalculation() {
    override fun calc(leftValue: Int, rightValue: Int): Int {
        return leftValue / rightValue
    }
}
