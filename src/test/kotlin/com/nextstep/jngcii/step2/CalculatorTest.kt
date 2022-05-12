package com.nextstep.jngcii.step2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {
    private val calculator = Calculator()

    @ParameterizedTest
    @CsvSource(
        "1, false, 2, false, 3, false",
        "-1, false, -2, false, -3, false",
        "1, false, 2, true, 3, true",
    )
    fun plusTest(
        lhsNum: Int,
        lhsBool: Boolean,
        rhsNum: Int,
        rhsBool: Boolean,
        resultNum: Int,
        resultBool: Boolean,
    ) {
        val lhs = POperator(lhsNum, lhsBool)
        val rhs = POperator(rhsNum, rhsBool)

        val result = calculator.plus(lhs, rhs)

        assertEquals(resultNum, result.value)
        assertEquals(resultBool, result.isEnd)
    }

    @ParameterizedTest
    @CsvSource(
        "3, false, 2, false, 1, false",
        "-1, false, -2, false, 1, false",
        "1, false, 2, true, -1, true",
    )
    fun minusTest(
        lhsNum: Int,
        lhsBool: Boolean,
        rhsNum: Int,
        rhsBool: Boolean,
        resultNum: Int,
        resultBool: Boolean,
    ) {
        val lhs = POperator(lhsNum, lhsBool)
        val rhs = POperator(rhsNum, rhsBool)

        val result = calculator.minus(lhs, rhs)

        assertEquals(resultNum, result.value)
        assertEquals(resultBool, result.isEnd)
    }
}
