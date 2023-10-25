package study.step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullAndEmptySource

class OperationTest {

    @ParameterizedTest
    @MethodSource("calculateNumbersProvider")
    fun `수식을 입력하면 해당하는 연산자에 맞는 연산결과를 도출한다`(
        operation: Operation,
        inputNum1: Double,
        inputNum2: Double,
        expected: Double
    ) {
        assertThat(operation.calculateNumbers(inputNum1, inputNum2)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(value = ["!@#!@$", "++", "--", "**", "//"])
    fun `일치하는 연산자가 없을 경우 에러를 반환한다`(
        operationWord: String
    ) {
        assertThrows<IllegalArgumentException> {
            Operation.chooseOperation(operationWord)
        }
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `입력받는 연산자가 null이거나 빈경우 에러를 반환한다`(
        operationWord: String?
    ) {
        assertThrows<IllegalArgumentException> {
            Operation.chooseOperation(operationWord)
        }
    }

    companion object {
        @JvmStatic
        fun calculateNumbersProvider() = listOf(
            Arguments.of(Operation.PLUS, 1.0, 2.0, 3.0),
            Arguments.of(Operation.MINUS, 1.0, 2.0, -1.0),
            Arguments.of(Operation.MULTIPLY, 1.0, 2.0, 2.0),
            Arguments.of(Operation.DIVISION, 1.0, 2.0, 0.5),
        )
    }
}