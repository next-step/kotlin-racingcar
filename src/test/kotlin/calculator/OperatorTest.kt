package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun `사칙연산 기호인 경우`(input: String) {
        assertThat(Operator.operation(input)).isNotNull
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", " ", "1", "%"])
    fun `사칙연산 기호가 아닌 경우`(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Operator.operation(input)
        }
    }
}
