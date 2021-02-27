package study.racingcar.step2.operation

internal class PlusCalculation : AbstractCalculation() {
    internal override fun calculate(leftValue: Int, rightValue: Int): Int {
        return leftValue + rightValue
    }
}
