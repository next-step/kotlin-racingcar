package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class OperationTest {

    @CsvSource(value = ["+:12", "-:8", "*:20", "/:5"], delimiter = ':')
    @ParameterizedTest(name = "사칙연산 `{arguments}` 의 결과가 정상적으로 동작한다.")
    internal fun addTest(symbol: String, expected: String) {
        // given
        val operation = Operation.of(symbol)

        // when
        val result = operation.operate(10, 2)

        // then
        assertThat(result).isEqualTo(expected.toInt())
    }

    @ValueSource(strings = ["", "a", "2", ")"])
    @ParameterizedTest(name = " 잘못된 값 `{arguments}` 이 들어가면 예외가 발생한다.")
    internal fun calculateTest(input: String) {
        // when, then
        assertThatIllegalArgumentException().isThrownBy { Operation.of(input) }
    }
}
