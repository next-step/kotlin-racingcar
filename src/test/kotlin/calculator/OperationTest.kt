package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class OperationTest {
    @Test
    fun `operator없이 계산하면 에러 발생`() {
        val operation = Operation(Scalar(1))
        assertThatExceptionOfType(UninitializedPropertyAccessException::class.java)
            .isThrownBy { operation.calculate(Scalar(2)) }
    }

    @Test
    fun `operator를 넣고 계산하면 정상 동작`() {
        assertAll(
            {
                assertThat(
                    Operation(Scalar(10)).with(AddOperator).calculate(Scalar(2))
                ).isEqualTo(Scalar(12))
            },
            {
                assertThat(
                    Operation(Scalar(10)).with(SubtractOperator).calculate(Scalar(2))
                ).isEqualTo(Scalar(8))
            },
            {
                assertThat(
                    Operation(Scalar(10)).with(MultiplyOperator).calculate(Scalar(2))
                ).isEqualTo(Scalar(20))
            },
            {
                assertThat(
                    Operation(Scalar(10)).with(DivideOperator).calculate(Scalar(2))
                ).isEqualTo(Scalar(5))
            }
        )
    }
}
