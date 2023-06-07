package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

@DisplayName("Operator 열거 타입의")
class OperatorTest {

    @ParameterizedTest
    @MethodSource("operatorProvider")
    fun `findBySymbol 메서드는 유효한 인자 전달시 적절한 인스턴스를 반환한다`(input: String, expected: Operator) {
        val operator = Operator.findBySymbol(input)

        assertThat(operator).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "t", "*/"])
    fun `findBySymbol 메서드는 유효하지 않은 인자 전달시 예외를 던진다`(input: String) {
        assertThrows<IllegalArgumentException> {
            Operator.findBySymbol(input)
        }
    }

    companion object {
        @JvmStatic
        fun operatorProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("+", Operator.PLUS),
                Arguments.of("-", Operator.MINUS),
                Arguments.of("*", Operator.TIMES),
                Arguments.of("/", Operator.DIVIDE)
            )
        }
    }
}
