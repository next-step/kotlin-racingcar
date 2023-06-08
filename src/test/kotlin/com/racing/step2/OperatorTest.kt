package com.racing.step2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OperatorTest {

    @Test
    fun `덧셈연산 단위 테스트`() {
        // given
        val a = 6
        val b = 10
        val op = "+"
        val answer = 16

        // when
        val operator = Operator.Companion.from(op)
        val result = operator.run(a, b)

        // then
        Assertions.assertThat(result).isEqualTo(answer)
    }

    @Test
    fun `뺄셈연산 단위 테스트`() {
        // given
        val a = 16
        val b = 10
        val op = "-"
        val answer = 6

        // when
        val operator = Operator.Companion.from(op)
        val result = operator.run(a, b)

        // then
        Assertions.assertThat(result).isEqualTo(answer)
    }

    @Test
    fun `곱셈연산 단위 테스트`() {
        // given
        val a = 6
        val b = 10
        val op = "*"
        val answer = 60

        // when
        val operator = Operator.Companion.from(op)
        val result = operator.run(a, b)

        // then
        Assertions.assertThat(result).isEqualTo(answer)
    }

    @Test
    fun `나눗셈연산 단위 테스트`() {
        // given
        val a = 60
        val b = 10
        val op = "/"
        val answer = 6

        // when
        val operator = Operator.Companion.from(op)
        val result = operator.run(a, b)

        // then
        Assertions.assertThat(result).isEqualTo(answer)
    }

    @Test
    fun `0 으로 나누면 예외가 발생`() {
        // given
        val a = 60
        val b = 0
        val op = "/"

        // when
        val operator = Operator.Companion.from(op)

        // then
        assertThrows<IllegalArgumentException> {
            operator.run(a, b)
        }
    }
}
