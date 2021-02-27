package study.racingcar.step2.operation

abstract class AbstractCalculation {
    fun calculate(leftValue: String, rightValue: String): Int {
        return calculate(leftValue.toInt(), rightValue.toInt())
    }

    internal abstract fun calculate(leftValue: Int, rightValue: Int): Int
}
