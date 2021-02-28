package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class ExpressionTest {

    @ParameterizedTest
    @CsvSource("*,6", "+,5", "-,1", "/,1")
    fun `사칙연산`(token: String, result: Int) {
        //given
        val expression = Expression()
        expression.addExpToken("3")
        expression.addExpToken(token)
        expression.addExpToken("2")

        //when
        //then
        assertThat(expression.execute()).isEqualTo(result)
    }

    @Test
    fun `계산 후 추가 연산이 가능하다`() {
        //given
        val expression = Expression()
        expression.addExpToken("1")
        expression.addExpToken("+")
        expression.addExpToken("2")

        //중간 결과
        expression.execute()

        //추가연산
        expression.addExpToken("*")
        expression.addExpToken("3")

        //when
        //then
        assertThat(expression.execute()).isEqualTo(9)
    }

    @Test
    fun `사칙연산 기호가 아닐 시 예외발생`() {
        //given
        val expression = Expression()
        expression.addExpToken("1")

        //when
        //then
        assertThrows<IllegalArgumentException> { expression.addExpToken("|") }
    }

    @Test
    fun `아무 식이 없을 때 결과는 0`() {
        //given
        val expression = Expression()
        //when
        //then
        assertThat(expression.execute()).isEqualTo(0)
    }
}