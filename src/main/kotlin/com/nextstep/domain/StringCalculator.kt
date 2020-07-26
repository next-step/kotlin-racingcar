package com.nextstep.domain

import java.util.HashMap
import java.util.function.BinaryOperator

object StringCalculator {
    private val calculators: MutableMap<Operator, BinaryOperator<Int>> =
        HashMap()

    fun calculate(operator: Operator?, first: Int, second: Int): Int {
        checkEnableCalculate(operator, first, second)
        return calculators[operator]!!.apply(first, second)
    }

    private fun checkEnableCalculate(operator: Operator?, first: Int, second: Int) {
        if (Operator.DIVISION == operator && second == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
    }

    private fun add(): BinaryOperator<Int> {
        return BinaryOperator { a: Int, b: Int -> a + b }
    }

    private fun subtract(): BinaryOperator<Int> {
        return BinaryOperator { a: Int, b: Int -> a - b }
    }

    private fun multiply(): BinaryOperator<Int> {
        return BinaryOperator { a: Int, b: Int -> a * b }
    }

    private fun division(): BinaryOperator<Int> {
        return BinaryOperator { a: Int, b: Int -> a / b }
    }

    init {
        calculators[Operator.ADD] = add()
        calculators[Operator.SUBTRACT] = subtract()
        calculators[Operator.MULTIPLY] = multiply()
        calculators[Operator.DIVISION] = division()
    }
}
