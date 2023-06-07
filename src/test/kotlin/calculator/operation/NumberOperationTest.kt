package calculator.operation

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.math.BigDecimal

class NumberOperationTest {
    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/", "a", "23-"])
    fun `숫자가 아닌 문자열을 만들었을 때 IllegalArgumentException 발생`(input: String) {
        Assertions.assertThatThrownBy { NumberOperation(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("$input 는 숫자여야합니다.")
    }

    @Test
    fun `숫자 문자열이 들어왔을 때 에러 없이 생성`() {
        Assertions.assertThatCode { NumberOperation("23") }.doesNotThrowAnyException()
    }

    @Test
    fun `interpret 시 value 반환`() {
        // given
        val givenNumber = NumberOperation("12")

        // when
        val result = givenNumber.operate()

        // then
        Assertions.assertThat(result).isEqualTo(BigDecimal(12))
    }
}
