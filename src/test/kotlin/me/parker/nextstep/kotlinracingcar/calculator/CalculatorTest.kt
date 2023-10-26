package me.parker.nextstep.kotlinracingcar.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `두 수의 더하기 계산`() {
        val result = Calculator.calculate("1+2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    fun `두 수의 더하기 계산 - 공백을 포함한 문자열 입력`() {
        val result = Calculator.calculate(" 1 + 2 ");

        assertThat(result).isEqualTo(3);
    }

    @Test
    fun `두 수의 더하기 계산 - 공백을 포함한 문자열 입력2`() {
        val result = Calculator.calculate("  1 +     2 ");

        assertThat(result).isEqualTo(3);
    }
}