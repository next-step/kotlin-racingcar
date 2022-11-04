package calculator

import io.kotest.matchers.nulls.shouldNotBeNull
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["", "  ", "&,", "#", "="])
    fun `사칙연산 기호인 경우`(symbol: String) {
        assertThat(Operator(symbol)).shouldNotBeNull()
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  ", "&,", "#", "="])
    fun `사칙연산이 기호가 아닌 경우`(symbol: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Operator(symbol)
        }
    }
}