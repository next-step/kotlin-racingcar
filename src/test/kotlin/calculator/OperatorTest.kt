package calculator

import calculator.Operator.Companion.INVALID_OPERATOR_ERROR_MESSAGE
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("계산을 담당하는 연산자 객체인 `Operator` 테스트")
internal class OperatorTest {
    @DisplayName("주어진 연산자가 `Operator Enum class`에 존재하면 `getOperator` 함수를 호출 시 해당 `Operator` 반환")
    @ParameterizedTest
    @MethodSource("existOperators")
    fun given_CorrectOperatorValue_when_GetOperator_then_ReturnCorrectOperator(
        givenOperator: String,
        expectedOperator: Operator
    ) {
        assertThat(Operator.getOperator(givenOperator)).isEqualTo(expectedOperator)
    }

    @DisplayName("주어진 연산자가 `Operator Enum class`에 존재하지 않으면 `getOperator` 함수 호출 시 실패")
    @ParameterizedTest
    @MethodSource("notExistOperators")
    fun given_IncorrectOperatorValue_when_GetOperator_then_ThrowIllegalArgumentException(
        givenOperator: String,
        expectedException: Exception
    ) {
        assertThatThrownBy() {
            Operator.getOperator(givenOperator)
        }.isInstanceOf(expectedException::class.java)
            .hasMessageContaining(INVALID_OPERATOR_ERROR_MESSAGE)
    }

    @DisplayName("주어진 피연산자 값이 덧셈 연산 후에 `Int` 범위 내라면 덧셈 시 성공")
    @ParameterizedTest
    @MethodSource("canBePlusOperands")
    fun plusSuccessIfGivenCanBePlusOperands(
        firstOperand: Int,
        secondOperand: Int,
        expectedResultValue: Int
    ) {
        // Arrange
        val plusOperator = Operator.getOperator("+")

        // Act
        val resultValue = plusOperator.calculate(firstOperand, secondOperand)

        // Assert
        assertThat(resultValue).isEqualTo(expectedResultValue)
    }

    @DisplayName("주어진 피연산자 값이 덧셈 연산 후에 `Int` 범위 내가 아니라면 덧셈 시 틀린 값 반환")
    @ParameterizedTest
    @MethodSource("canNotBePlusOperands")
    fun plusFailIfGivenCanNotBePlusOperands(
        firstOperand: Int,
        secondOperand: Int,
        expectedResultValue: Long
    ) {
        // Arrange
        val plusOperator = Operator.getOperator("+")

        // Act
        val resultValue = plusOperator.calculate(firstOperand, secondOperand).toLong()

        // Assert
        assertThat(resultValue).isNotEqualTo(expectedResultValue)
    }

    @DisplayName("주어진 피연산자 값이 뺄셈 연산 후에 `Int` 범위 내라면 뺄셈 시 성공")
    @ParameterizedTest
    @MethodSource("canBeMinusOperands")
    fun minusSuccessIfGivenCanBeMinusOperands(
        firstOperand: Int,
        secondOperand: Int,
        expectedResultValue: Int
    ) {
        // Arrange
        val minusOperator = Operator.getOperator("-")

        // Act
        val resultValue = minusOperator.calculate(firstOperand, secondOperand)

        // Assert
        assertThat(resultValue).isEqualTo(expectedResultValue)
    }

    @DisplayName("주어진 피연산자 값이 뺄셈 연산 후에 `Int` 범위 내가 아니라면 뺄셈 시 틀린 값 반환")
    @ParameterizedTest
    @MethodSource("canNotBeMinusOperands")
    fun minusFailIfGivenCanNotBeMinusOperands(
        firstOperand: Int,
        secondOperand: Int,
        expectedResultValue: Long
    ) {
        // Arrange
        val minusOperator = Operator.getOperator("-")

        // Act
        val resultValue = minusOperator.calculate(firstOperand, secondOperand).toLong()

        // Assert
        assertThat(resultValue).isNotEqualTo(expectedResultValue)
    }

    @DisplayName("주어진 피연산자 값이 곱셈 연산 후에 `Int` 범위 내라면 곱셈 시 성공")
    @ParameterizedTest
    @MethodSource("canBeMultiOperands")
    fun multiSuccessIfGivenCanBeMultiOperands(
        firstOperand: Int,
        secondOperand: Int,
        expectedResultValue: Int
    ) {
        // Arrange
        val multiOperator = Operator.getOperator("*")

        // Act
        val resultValue = multiOperator.calculate(firstOperand, secondOperand)

        // Assert
        assertThat(resultValue).isEqualTo(expectedResultValue)
    }

    @DisplayName("주어진 피연산자 값이 곱셈 연산 후에 `Int` 범위 내가 아니라면 곱셈 시 틀린 값 반환")
    @ParameterizedTest
    @MethodSource("canNotBeMultiOperands")
    fun multiFailIfGivenCanNotBeMultiOperands(
        firstOperand: Int,
        secondOperand: Int,
        expectedResultValue: Long
    ) {
        // Arrange
        val multiOperator = Operator.getOperator("*")

        // Act
        val resultValue = multiOperator.calculate(firstOperand, secondOperand).toLong()

        // Assert
        assertThat(resultValue).isNotEqualTo(expectedResultValue)
    }

    @DisplayName("주어진 피연산자 값이 나눗셈 연산 후에 `Int` 범위 내라면 나눗셈 시 성공")
    @ParameterizedTest
    @MethodSource("canBeDivideOperands")
    fun divideSuccessIfGivenCanBeDivideOperands(
        firstOperand: Int,
        secondOperand: Int,
        expectedResultValue: Int
    ) {
        // Arrange
        val divideOperator = Operator.getOperator("/")

        // Act
        val resultValue = divideOperator.calculate(firstOperand, secondOperand)

        // Assert
        assertThat(resultValue).isEqualTo(expectedResultValue)
    }

    @DisplayName("`0`으로 나누면 나눗셈 연산 실패")
    @ParameterizedTest
    @MethodSource("canNotBeDivideOperands")
    fun divideFailIfGivenCanNotBeDivideOperands(
        firstOperand: Int,
        secondOperand: Int,
        expectedException: Exception,
        containErrorMessage: String
    ) {
        // Arrange
        val divideOperator = Operator.getOperator("/")

        // Act & Assert
        assertThatThrownBy() {
            divideOperator.calculate(firstOperand, secondOperand)
        }.isInstanceOf(expectedException::class.java)
            .hasMessageContaining(containErrorMessage)
    }

    companion object {
        private const val arithmeticExceptionErrorMessage = "by zero"
        private val illegalArgumentException = IllegalArgumentException()
        private val arithmeticException = ArithmeticException()

        @JvmStatic
        fun existOperators(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("+", Operator.ADDITION),
                Arguments.of("-", Operator.SUBTRACTION),
                Arguments.of("*", Operator.MULTIPLICATION),
                Arguments.of("/", Operator.DIVISION)
            )
        }

        @JvmStatic
        fun notExistOperators(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("!", illegalArgumentException),
                Arguments.of("@", illegalArgumentException),
                Arguments.of("#", illegalArgumentException),
                Arguments.of("$", illegalArgumentException),
                Arguments.of("%", illegalArgumentException),
                Arguments.of("^", illegalArgumentException),
                Arguments.of("&", illegalArgumentException),
                Arguments.of("_", illegalArgumentException),
                Arguments.of(".", illegalArgumentException),
                Arguments.of("?", illegalArgumentException),
                Arguments.of("0", illegalArgumentException),
                Arguments.of("1", illegalArgumentException),
            )
        }

        @JvmStatic
        fun canBePlusOperands(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(10, 22, 32),
                Arguments.of(-1, -2, -3),
                Arguments.of(-3, 8, 5),
                Arguments.of(0, 0, 0),
                Arguments.of(100_000_000, 2_000_000, 102_000_000),
                Arguments.of(-123_123_123, -123_123_123, -246_246_246),
                Arguments.of(1_000_000_000, 1_000_000_000, 2_000_000_000),
                Arguments.of(-1_000_000_000, -1_000_000_000, -2_000_000_000),
            )
        }

        @JvmStatic
        // operandsWhatEnablePlus
        fun canNotBePlusOperands(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(2_000_000_000, 2_000_000_000, 4_000_000_000),
                Arguments.of(-2_000_000_000, -2_000_000_000, -4_000_000_000),
            )
        }

        @JvmStatic
        fun canBeMinusOperands(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1, 2, -1),
                Arguments.of(797, 111, 686),
                Arguments.of(-1, 2, -3),
                Arguments.of(-3, 8, -11),
                Arguments.of(0, 0, 0),
                Arguments.of(100_000_000, 2_000_000, 98_000_000),
                Arguments.of(-123_123_123, -123_123_123, 0),
                Arguments.of(1_000_000_000, -1_000_000_000, 2_000_000_000),
                Arguments.of(-1_000_000_000, 1_000_000_000, -2_000_000_000),
            )
        }

        @JvmStatic
        fun canNotBeMinusOperands(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(2_000_000_000, -2_000_000_000, 4_000_000_000),
                Arguments.of(-2_000_000_000, 2_000_000_000, -4_000_000_000),
            )
        }

        @JvmStatic
        fun canBeMultiOperands(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1, 2, 2),
                Arguments.of(797, 111, 88_467),
                Arguments.of(-1, 2, -2),
                Arguments.of(-3, 8, -24),
                Arguments.of(0, 0, 0),
                Arguments.of(10_000, 10_000, 100_000_000),
                Arguments.of(200_000, 10_000, 2_000_000_000),
                Arguments.of(-200_000, 10_000, -2_000_000_000),
                Arguments.of(-1, -1, 1),
            )
        }

        @JvmStatic
        fun canNotBeMultiOperands(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(100_000, 100_000, 10_000_000_000),
                Arguments.of(-100_000, 200_000, -20_000_000_000),
                Arguments.of(-100_000, -200_000, 20_000_000_000),
            )
        }

        @JvmStatic
        fun canBeDivideOperands(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(2, 1, 2),
                Arguments.of(4, 2, 2),
                Arguments.of(-1, -1, 1),
                Arguments.of(10_000, 5, 2_000),
                Arguments.of(777_777_777, 7, 111_111_111),
                Arguments.of(880_000, 10_000, 88),
                Arguments.of(-200_000, 10_000, -20),
                Arguments.of(0, 10_000, 0),
            )
        }

        @JvmStatic
        fun canNotBeDivideOperands(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(0, 0, arithmeticException, arithmeticExceptionErrorMessage),
                Arguments.of(100_000, 0, arithmeticException, arithmeticExceptionErrorMessage),
            )
        }
    }
}
