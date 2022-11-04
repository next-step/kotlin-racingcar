package step1.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("연산자 타입")
internal class OperationTypeTest {
    @ParameterizedTest(name = "[Case#{index}]{0} : {1}")
    @MethodSource
    @DisplayName("문자열 연산자에 따른 연산자 타입을 반환한다.")
    fun getOperatorTypeByOperator(given: String, expected: OperationType) {
        // When
        val actual = OperationType.match(given)

        // Then
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    @DisplayName("정의된 연산자 타입이 아닌 경우 예외가 발생한다.")
    fun throwException_WhenInvalidOperator() {
        // Given
        val given = "%"

        // When & Then
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { OperationType.match(given) }
    }

    @ParameterizedTest(name = "[Case#{index}]{1} {0} {2} = {3}")
    @MethodSource
    @DisplayName("연산자 타입에 해당하는 수식을 연산한다.")
    fun calculateByOperator(
        given: String,
        leftTerm: Double,
        rightTerm: Double,
        expected: Double
    ) {
        // When
        val actual = OperationType.match(given)
            .calculate(leftTerm, rightTerm)

        // Then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("제수가 0인 경우 예외가 발생한다.")
    fun throwException_WhenZeroDivisor(leftTerm: Double) {
        // Given
        val operationType = OperationType.DIVIDE
        val given = 0.0

        // When & Then
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { operationType.calculate(leftTerm, given) }
    }

    companion object {
        @JvmStatic
        fun getOperatorTypeByOperator(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("+", OperationType.PLUS),
                Arguments.of("-", OperationType.MINUS),
                Arguments.of("*", OperationType.MULTIPLY),
                Arguments.of("/", OperationType.DIVIDE)
            )
        }

        @JvmStatic
        fun calculateByOperator(): Stream<Arguments> {
            val leftTerm = 4.0
            val rightTerm = 2.0
            return Stream.of(
                Arguments.of("+", leftTerm, rightTerm, 6.0),
                Arguments.of("-", leftTerm, rightTerm, 2.0),
                Arguments.of("*", leftTerm, rightTerm, 8.0),
                Arguments.of("/", leftTerm, rightTerm, 2.0)
            )
        }

        @JvmStatic
        fun throwException_WhenZeroDivisor(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Double.POSITIVE_INFINITY),
                Arguments.of(Double.NEGATIVE_INFINITY)
            )
        }
    }
}
