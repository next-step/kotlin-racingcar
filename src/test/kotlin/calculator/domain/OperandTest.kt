package calculator.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class OperandTest {

    @ParameterizedTest
    @EmptySource
    fun `빈 문자열은 유효한 피연산자가 될 수 없다`(value: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Operand(value) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["k", "o", "t", "l", "i", "n"])
    fun `숫자가 아닌 문자는 유효한 피연산자가 될 수 없다`(value: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Operand(value) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0.0", "1.0", "100", "20"])
    fun `숫자는 피연산자가 될 수 있다`(value: String) {
        assertThat(Operand(value).value).isEqualTo(value.toDouble())
    }
}
