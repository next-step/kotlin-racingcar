package com.nextstep.jngcii.step2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {
    private val calculator = Calculator()

    @ParameterizedTest
    @CsvSource(
        "1, false, 2, false, +,  3, false",
        "-1, false, -2, false, +, -3, false",
        "1, false, 2, true, +, 3, true",

        "3, false, 2, false, -, 1, false",
        "-1, false, -2, false, -, 1, false",
        "1, false, 2, true, -, -1, true",

        "3, false, 2, false, *, 6, false",
        "-1, false, -2, false, *, 2, false",
        "-1, false, 2, true, *, -2, true",

        "3, false, 1, false, /, 3, false",
        "-2, false, -2, false, /, 1, false",
        "-4, false, 2, true, /, -2, true",
    )
    fun `계산 테스트`(
        lhsNum: Int,
        lhsBool: Boolean,
        rhsNum: Int,
        rhsBool: Boolean,
        operatorStr: String,
        resultNum: Int,
        resultBool: Boolean,
    ) {
        val lhs = POperator(lhsNum, lhsBool)
        val rhs = POperator(rhsNum, rhsBool)
        val op = Operator.of(operatorStr)

        val result = calculator.run(lhs, rhs, op)

        assertEquals(resultNum, result.value)
        assertEquals(resultBool, result.isEnd)
    }
}
