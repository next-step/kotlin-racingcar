package step1.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("연산자 타입")
internal class OperationTypeTest {
    @ParameterizedTest(name = "[Case#{index}]{0} : {1}")
    @MethodSource
    @DisplayName("연산자에 따른 타입을 반환한다.")
    fun getOperatorTypeByOperator(given: String, expected: OperationType) {
        // When
        val actual = OperationType.match(given)

        // Then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "[Case#{index}]{1} {0} {2} = {3}")
    @MethodSource
    @DisplayName("연산자 타입에 해당하는 수식을 연산한다.")
    fun calculateByOperator(
        given: String,
        leftValue: Double,
        rightValue: Double,
        expected: Double
    ) {
        // When
        val actual = OperationType.match(given)
            .calculate(leftValue, rightValue)

        // Then
        assertThat(actual).isEqualTo(expected)
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
            val leftValue = 4.0
            val rightValue = 2.0
            return Stream.of(
                Arguments.of("+", leftValue, rightValue, 6.0),
                Arguments.of("-", leftValue, rightValue, 2.0),
                Arguments.of("*", leftValue, rightValue, 8.0),
                Arguments.of("/", leftValue, rightValue, 2.0)
            )
        }
    }
}
