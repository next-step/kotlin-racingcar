package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class OperationTest {
    @Test
    fun `operator없이 계산하면 에러 발생`() {
        val operation = Operation(Scalar(1))
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { operation.with(Scalar(2)) }
            .withMessage("The operator does not exist.")
    }

    @Test
    fun `operator를 넣고 계산하면 정상 동작`() {
        assertAll(
            {
                assertThat(
                    Operation(Scalar(10))
                        .with(AddOperator)
                        .with(Scalar(2))
                        .result
                ).isEqualTo(Scalar(12))
            },
            {
                assertThat(
                    Operation(Scalar(10))
                        .with(SubtractOperator)
                        .with(Scalar(2))
                        .result
                ).isEqualTo(Scalar(8))
            },
            {
                assertThat(
                    Operation(Scalar(10))
                        .with(MultiplyOperator)
                        .with(Scalar(2))
                        .result
                ).isEqualTo(Scalar(20))
            },
            {
                assertThat(
                    Operation(Scalar(10))
                        .with(DivideOperator)
                        .with(Scalar(2))
                        .result
                ).isEqualTo(Scalar(5))
            }
        )
    }

    @Test
    fun `Operator를 두 번 연속으로 넣으면 IllegalArgumentException throw`() {
        assertThatIllegalArgumentException()
            .isThrownBy {
                Operation(Scalar(10))
                    .with(AddOperator)
                    .with(MultiplyOperator)
            }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 1, 154])
    fun `입력값이 단일 숫자면 해당 숫자를 반환`(value: Int) {
        assertAll(
            { assertThat(Operation(Scalar(value)).result).isEqualTo(Scalar(value)) },
            { assertThat(Operation.Empty.with(Scalar(value)).result).isEqualTo(Scalar(value)) }
        )
    }
}
