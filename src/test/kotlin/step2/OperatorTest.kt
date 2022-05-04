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
        assertThrows<java.lang.IllegalArgumentException> { Operator.of("^") }
    }
}