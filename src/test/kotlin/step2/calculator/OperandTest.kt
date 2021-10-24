package step2.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("피연산자 객체 Operand 생성 테스트")
internal class OperandTest {
    @DisplayName("피연산자 생성 테스트")
    @ParameterizedTest
    @MethodSource("validOperand")
    fun createOperandWhenGivenValidOperand(givenOperand: Int) {
        // Arrange
        // Act
        val operand = Operand(givenOperand)

        // Assert
        assertThat(operand.value).isEqualTo(givenOperand)
    }

    companion object {
        @JvmStatic
        fun validOperand(): Stream<Arguments> {
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
