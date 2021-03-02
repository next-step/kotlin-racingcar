package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class DivideOperatorTest {
    @ParameterizedTest
    @CsvSource("0,1,0", "5,3,1", "2,5,0", "4,-2,-2", "-50,8,-6")
    fun `나누기`(a: Int, b: Int, result: Int) {
        assertThat(
            DivideOperator.operate(Scalar(a), Scalar(b))
        ).isEqualTo(Scalar(result))
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 0, -2])
    fun `0으로 나누면 안됨`(a: Int) {
        assertThatExceptionOfType(ArithmeticException::class.java)
            .isThrownBy { DivideOperator.operate(Scalar(a), Scalar(0)) }
            .withMessage("/ by zero")
    }
}
