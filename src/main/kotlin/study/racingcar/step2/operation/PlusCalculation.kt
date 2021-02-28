package study.racingcar.step2.operation

internal class PlusCalculation : AbstractCalculation() {
    override fun calc(leftValue: Int, rightValue: Int): Int {
        return leftValue + rightValue
    }
}
