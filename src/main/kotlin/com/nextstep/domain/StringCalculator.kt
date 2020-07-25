package com.nextstep.domain

import java.util.HashMap
import java.util.function.BinaryOperator

object StringCalculator {
    private val calculators: MutableMap<Operator, BinaryOperator<Int>> =
        HashMap()

    fun calculate(operator: Operator?, first: Int, second: Int): Int {
        return calculators[operator]!!.apply(first, second)
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
