package study.racingcar.step2.operation

abstract class AbstractCalculation {
    fun calculate(leftValue: String, rightValue: String): Int {
        return calc(leftValue.toInt(), rightValue.toInt())
    }

    protected abstract fun calc(leftValue: Int, rightValue: Int): Int
}
