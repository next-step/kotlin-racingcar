package com.nextstep.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringCalculatorTest {
    @Test
    fun `덧셈 연산을 수행한다`() {
        assertThat(StringCalculator.calculate(Operator.ADD, 1, 2)).isEqualTo(3)
    }

    @Test
    fun `뺄셈 연산을 수행한다`() {
        assertThat(StringCalculator.calculate(Operator.SUBTRACT, 1, 2)).isEqualTo(-1)
    }

    @Test
    fun `곱하기 연산을 수행한다`() {
        assertThat(StringCalculator.calculate(Operator.MULTIPLY, 1, 2)).isEqualTo(2)
    }

    @Test
    fun `나누기 연산을 수행한다`() {
        assertThat(StringCalculator.calculate(Operator.DIVISION, 1, 2)).isEqualTo(0)
    }
}
