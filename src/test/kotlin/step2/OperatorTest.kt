package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class OperatorTest {

    @Test
    fun `사칙연산에 포함된 연산자 인지 확인한다`() {
        assertAll(
            { assertThat(Operator.of("+")).isEqualTo(Operator.ADD) },
            { assertThat(Operator.of("-")).isEqualTo(Operator.MINUS) },
            { assertThat(Operator.of("*")).isEqualTo(Operator.MULTIPLY) },
            { assertThat(Operator.of("/")).isEqualTo(Operator.DIVIDE) },
        )
    }

    @Test
    fun `사칙연산에 포함되지 않는다면 에러를 발생한다`() {
        assertThrows<IllegalArgumentException> { Operator.of("^") }
    }

    @Test
    fun `더하기 연산이 성공적으로 나온다`() {
        val expected = 4L
        val addSum = Operator.of("+").operate(1, 3)

        assertThat(addSum).isEqualTo(expected)
    }

    @Test
    fun `빼기 연산이 성공적으로 나온다`() {
        val expected = 3L
        val addSum = Operator.of("-").operate(5, 2)

        assertThat(addSum).isEqualTo(expected)
    }

    @Test
    fun `곱하기 연산이 성공적으로 나온다`() {
        val expected = 9L
        val addSum = Operator.of("*").operate(3, 3)

        assertThat(addSum).isEqualTo(expected)
    }

    @Test
    fun `나누기 연산이 성공적으로 나온다`() {
        val expected = 3L
        val addSum = Operator.of("/").operate(6, 2)

        assertThat(addSum).isEqualTo(expected)
    }
}
