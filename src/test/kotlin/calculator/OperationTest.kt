package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class OperationTest {
    @Test
    fun `operator없이 계산하면 에러 발생`() {
        val operation = Operation(Scalar(1))
        assertThatExceptionOfType(IllegalStateException::class.java)
            .isThrownBy { operation.with(Scalar(2)) }
            .withMessage("The operator does not exist.")
    }

    @Test
    fun `operator를 넣고 계산하면 정상 동작`() {
        assertAll(
            {
                assertThat(
                    Operation(Scalar(10))
                        .with(Operator.ADD)
                        .with(Scalar(2))
                        .result
                ).isEqualTo(Scalar(12))
            },
            {
                assertThat(
                    Operation(Scalar(10))
                        .with(Operator.SUBTRACT)
                        .with(Scalar(2))
                        .result
                ).isEqualTo(Scalar(8))
            },
            {
                assertThat(
                    Operation(Scalar(10))
                        .with(Operator.MULTIPLY)
                        .with(Scalar(2))
                        .result
                ).isEqualTo(Scalar(20))
            },
            {
                assertThat(
                    Operation(Scalar(10))
                        .with(Operator.DIVIDE)
                        .with(Scalar(2))
                        .result
                ).isEqualTo(Scalar(5))
            }
        )
    }

    @Test
    fun `Operator를 두 번 연속으로 넣으면 IllegalArgumentException throw`() {
        assertThatExceptionOfType(IllegalStateException::class.java)
            .isThrownBy {
                Operation(Scalar(10))
                    .with(Operator.ADD)
                    .with(Operator.MULTIPLY)
            }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 1, 154])
    fun `입력값이 단일 숫자면 해당 숫자를 반환`(value: Int) {
        assertAll(
            { assertThat(Operation(Scalar(value)).result).isEqualTo(Scalar(value)) },
            { assertThat(Operation.EMPTY.with(Scalar(value)).result).isEqualTo(Scalar(value)) }
        )
    }
}
