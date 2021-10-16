package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class OperandTest {

    @ParameterizedTest
    @ValueSource(strings = ["a", "테스트", "1/2"])
    @NullAndEmptySource
    fun `잘못된 값으로 Operand 를 생성하면 IllegalArgumentException이 발생한다`(input: String?) {
        Assertions.assertThatThrownBy {
            Operand.from(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "10.5", "-7.8", "0", "+120.34"])
    fun `정상적인 값이 입력된 경우 Operand가 정상적으로 생성된다`(input: String) {
        val operand = Operand.from(input)

        assertThat(operand).isEqualTo(Operand(input.toBigDecimal()))
    }
}
