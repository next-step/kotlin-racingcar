package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("피연산자 값 객체인 `Operand` 테스트")
internal class OperandTest {
    @DisplayName("주어진 피연산자 값이 `Int`로 표현 가능하면 `Operand` 객체 생성 시 성공")
    @ParameterizedTest
    @MethodSource("normalIntValue")
    fun given_CorrectOperandValue_when_CreateOperand_then_CreateSuccess(givenOperand: Int) {
        // Arrange
        // Act
        val operand = Operand(givenOperand)

        // Assert
        assertThat(operand.value).isEqualTo(givenOperand)
    }

    companion object {
        @JvmStatic
        fun normalIntValue(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1),
                Arguments.of(0),
                Arguments.of(1_000_000_000),
                Arguments.of(2_000_000_000),
                Arguments.of(-1_000_000_000),
                Arguments.of(-2_000_000_000),
            )
        }
    }
}
