package study.racingcar.step2.operation

internal class DivisionCalculation : AbstractCalculation() {
    internal override fun calculate(leftValue: Int, rightValue: Int): Int {
        return leftValue / rightValue
    }
}
