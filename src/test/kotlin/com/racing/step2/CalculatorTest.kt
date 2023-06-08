package com.racing.step2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class CalculatorTest {
    @Test
    fun `일반적인 수학 계산을 할 수 있는 계산기를 만든다`() {
        // given
        val input = "3 + 4 - 1 / 3 + 5"
        val answer = 7

        // when
        val calculator = Calculator()
        val result = calculator.exec(input)

        // then
        Assertions.assertThat(result).isEqualTo(answer)
    }

    @Test
    fun `일반적인 수학 계산을 할 수 있는 계산기를 만드는 케이스`() {
        // given
        val input = "3 + 10 - 1 / 2 + 5"
        val answer = 11

        // when
        val calculator = Calculator()
        val result = calculator.exec(input)

        // then
        Assertions.assertThat(result).isEqualTo(answer)
    }

    @Test
    fun `일반적인 수학 계산처럼 보이지만 0 으로는 나눌 수 없다`() {
        // given
        val input = "3 + 10 - 1 / 0 + 5"

        // when
        val calculator = Calculator()

        // then
        Assertions.assertThatThrownBy {
            calculator.exec(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw 반환한다`() {
        // given
        val input = ""
        val input2 = " "

        // when
        val calculator = Calculator()

        // then
        Assertions.assertThatThrownBy {
            calculator.exec(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)

        Assertions.assertThatThrownBy {
            calculator.exec(input2)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw 반환한다`() {
        // given
        val input = "intput string"

        // when
        val calculator = Calculator()

        // then
        Assertions.assertThatThrownBy {
            calculator.exec(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
