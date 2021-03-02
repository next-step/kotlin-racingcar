package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class OperationTest {
    @Test
    fun `operator없이 계산하면 에러 발생`() {
        val operation = Operation(Scalar(1))
        assertThatExceptionOfType(IllegalStateException::class.java)
            .isThrownBy { operation.operate(Scalar(2)) }
            .withMessage("The operator does not exist.")
    }

    @ParameterizedTest
    @CsvSource("ADD, 12", "SUBTRACT, 8", "MULTIPLY, 20", "DIVIDE, 5")
    fun `operator를 넣고 계산하면 정상 동작`(operator: Operator, expectedResult: Int) {
        assertThat(
            Operation(Scalar(10), operator)
                .operate(Scalar(2))
                .result
        ).isEqualTo(Scalar(expectedResult))
    }

    @Test
    fun `Operator를 두 번 연속으로 넣으면 IllegalArgumentException throw`() {
        assertAll(
            {
                assertThatExceptionOfType(IllegalStateException::class.java)
                    .isThrownBy {
                        val operation = Operation(Scalar(10), Operator.ADD)
                        operation.operator = Operator.MULTIPLY
                    }
            },
            {
                assertThatExceptionOfType(IllegalStateException::class.java)
                    .isThrownBy {
                        val operation = Operation(Scalar(10))
                        operation.operator = Operator.DIVIDE
                        operation.operator = Operator.SUBTRACT
                    }
            }
        )
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 1, 154])
    fun `입력값이 단일 숫자면 해당 숫자를 반환`(value: Int) {
        assertAll(
            { assertThat(Operation(Scalar(value)).result).isEqualTo(Scalar(value)) },
            { assertThat(Operation.EMPTY.operate(Scalar(value)).result).isEqualTo(Scalar(value)) }
        )
    }
}
