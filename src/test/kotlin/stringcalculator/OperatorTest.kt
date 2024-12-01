package stringcalculator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["%", "!", "?", ">", "<"])
    fun `지원하지 않는 연산자를 사용할 경우 예외를 발생시킨다`(sequence: String) {
        assertThatThrownBy { Operator.fromSequence(sequence) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
