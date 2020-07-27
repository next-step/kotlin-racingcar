package com.nextstep.stringcalculator.domain

import java.util.HashMap

object StringCalculator {
    private val calculators: MutableMap<Operator, (Double, Double) -> Double> =
        HashMap()

    fun calculate(operator: Operator?, first: Double, second: Double): Double {
        checkEnableCalculate(operator, first, second)
        return calculators[operator]?.invoke(first, second)
            ?: throw IllegalArgumentException("해당 연산을 수행할 수 없습니다.")
    }

    private fun checkEnableCalculate(operator: Operator?, first: Double, second: Double) {

        if (Operator.DIVISION == operator && second == 0.0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
    }

    private fun add(): (Double, Double) -> Double = { a: Double, b: Double -> a + b }

    private fun subtract(): (Double, Double) -> Double = { a: Double, b: Double -> a - b }

    private fun multiply(): (Double, Double) -> Double = { a: Double, b: Double -> a * b }

    private fun division(): (Double, Double) -> Double = { a: Double, b: Double -> a / b }

    init {
        calculators[Operator.ADD] = add()
        calculators[Operator.SUBTRACT] = subtract()
        calculators[Operator.MULTIPLY] = multiply()
        calculators[Operator.DIVISION] = division()
    }
}
